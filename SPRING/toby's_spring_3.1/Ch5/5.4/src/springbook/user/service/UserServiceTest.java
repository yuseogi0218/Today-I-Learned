package springbook.user.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static springbook.user.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class UserServiceTest {

    // Field 주입
    @Autowired UserService userService;

    @Autowired UserDao userDao;

    @Autowired PlatformTransactionManager transactionManager;

    @Autowired MailSender mailSender;

    List<User> users;	// test fixture

    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", "user1@ksug.org", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
                new User("joytouch", "강명성", "p2", "user2@ksug.org", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
                new User("erwins", "신승한", "p3", "user3@ksug.org", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD - 1),
                new User("madnite1", "이상호", "p4", "user4@ksug.org", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD),
                new User("green", "오민규", "p5", "user5@ksug.org", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    @DirtiesContext // 컨텍스트의 DI 설정을 변경하는 테스트라는 것을 알려준다.
    // 여기서는, UserService 의 MailSender DI 설정을 변경한다.
    public void upgradeLevels() throws Exception {
        userDao.deleteAll();

        for (User user : users) {
            userDao.add(user);
        }

        MockMailSender mockMailSender = new MockMailSender();
        userService.setMailSender(mockMailSender);

        // level upgrade 서비스 호출
        userService.upgradeLevels();

        checkLevelUpgraded(users.get(0), false);
        checkLevelUpgraded(users.get(1), true);
        checkLevelUpgraded(users.get(2), false);
        checkLevelUpgraded(users.get(3), true);
        checkLevelUpgraded(users.get(4), false);

        List<String> requests = mockMailSender.getRequests();
        assertThat(requests.size(), is(2));
        assertThat(requests.get(0), is(users.get(1).getEmail()));
        assertThat(requests.get(1), is(users.get(3).getEmail()));
    }

    static class MockMailSender implements MailSender {

        private List<String> requests = new ArrayList<>();

        public List<String> getRequests() {
            return requests;
        }

        @Override
        public void send(SimpleMailMessage simpleMailMessage) throws MailException {
            requests.add(simpleMailMessage.getTo()[0]);
        }

        @Override
        public void send(SimpleMailMessage[] simpleMailMessages) throws MailException {

        }
    }

    @Test
    public void add() {
        userDao.deleteAll();

        // GOLD 레벨이 이미 설정되어 있는 사용자
        User userWithLevel = users.get(4);

        userService.add(userWithLevel);

        User userWithLevelRead = userDao.get(userWithLevel.getId());
        assertThat(userWithLevelRead.getLevel(), is(userWithLevel.getLevel()));

        // 레벨이 설정되어 있지 않은 사용자
        User userWithoutLevel = users.get(0);
        userWithoutLevel.setLevel(null);

        userService.add(userWithoutLevel);

        User userWithoutLevelRead = userDao.get(userWithoutLevel.getId());
        assertThat(userWithoutLevelRead.getLevel(), is(Level.BASIC));

    }

    private void checkLevelUpgraded(User testUser, boolean upgraded) {
        User userUpdate = userDao.get(testUser.getId());

        if (upgraded) {
            assertThat(userUpdate.getLevel(), is(testUser.getLevel().nextLevel()));
        } else {
            assertThat(userUpdate.getLevel(), is(testUser.getLevel()));
        }
    }

    @Test
    public void upgradeAllOrNothing() throws Exception{
        UserService testUserService = new TestUserService(users.get(3).getId());
        testUserService.setUserDao(this.userDao); // userDao 를 수동 DI 해준다.
        testUserService.setTransactionManager(transactionManager);
        testUserService.setMailSender(mailSender);

        userDao.deleteAll();

        for (User user : users) {
            userDao.add(user);
        }

        try {
            testUserService.upgradeLevels();
            fail("TestUserServiceException expected"); // 예외가 발생하여 실패할 것을 예상한다.
        } catch (TestUserServiceException e) {
        }

        checkLevelUpgraded(users.get(1), false);
    }

    static class TestUserService extends UserService {

        private String id;

        private TestUserService(String id) {
            this.id = id;
        }

        @Override
        protected void upgradeLevel(User user) {
            if (user.getId().equals(this.id)) {
                throw new TestUserServiceException();
            }
            super.upgradeLevel(user);
        }
    }

    static class TestUserServiceException extends RuntimeException {
    }


}

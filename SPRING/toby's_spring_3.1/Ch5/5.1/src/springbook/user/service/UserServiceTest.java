package springbook.user.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.user.dao.UserDao;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static springbook.user.service.UserService.MIN_LOGCOUNT_FOR_SILVER;
import static springbook.user.service.UserService.MIN_RECCOMEND_FOR_GOLD;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class UserServiceTest {

    // Field 주입
    @Autowired UserService userService;

    @Autowired UserDao userDao;

    List<User> users;	// test fixture

    @Before
    public void setUp() {
        users = Arrays.asList(
                new User("bumjin", "박범진", "p1", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER - 1, 0),
                new User("joytouch", "강명성", "p2", Level.BASIC, MIN_LOGCOUNT_FOR_SILVER, 0),
                new User("erwins", "신승한", "p3", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD - 1),
                new User("madnite1", "이상호", "p4", Level.SILVER, 60, MIN_RECCOMEND_FOR_GOLD),
                new User("green", "오민규", "p5", Level.GOLD, 100, Integer.MAX_VALUE)
        );
    }

    @Test
    public void upgradeLevels() {
        userDao.deleteAll();

        for (User user : users) {
            userDao.add(user);
        }

        // level upgrade 서비스 호출
        userService.upgradeLevels();

        checkLevel(users.get(0), false);
        checkLevel(users.get(1), true);
        checkLevel(users.get(2), false);
        checkLevel(users.get(3), true);
        checkLevel(users.get(4), false);

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

    private void checkLevel(User testUser, boolean upgraded) {
        User userUpdate = userDao.get(testUser.getId());

        if (upgraded) {
            assertThat(userUpdate.getLevel(), is(testUser.getLevel().nextLevel()));
        } else {
            assertThat(userUpdate.getLevel(), is(testUser.getLevel()));
        }
    }
}

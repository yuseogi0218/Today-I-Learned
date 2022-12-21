package springbook.user.dao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.support.SQLErrorCodeSQLExceptionTranslator;
import org.springframework.jdbc.support.SQLExceptionTranslator;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.user.domain.Level;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * userDAO 테스트
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/test-applicationContext.xml")
public class UserDaoTest {

    @Autowired UserDao userDao;

    @Autowired DataSource dataSource;


    private User user1;
    private User user2;
    private User user3;


    @Before
    public void setUp() {

        this.user1 = new User("gyumee", "박성철", "springno1", Level.BASIC, 1, 0);
        this.user2 = new User("leegw700", "이길원", "springno2", Level.SILVER, 55, 10);
        this.user3 = new User("bumjin", "박범진", "springno3", Level.GOLD, 100, 40);
    }


    @Test
    public void addAndGet() throws SQLException {

        // delete All test
        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        // select test
        User searchedUser1 = userDao.get(user1.getId());
        checkSameUser(searchedUser1, user1);

        User searchedUser2 = userDao.get(user2.getId());
        checkSameUser(searchedUser2, user2);

    }

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {

        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.get("unknown_id");

    }

    @Test
    public void count() throws SQLException {

        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.add(user1);
        assertThat(userDao.getCount(), is(1));

        userDao.add(user2);
        assertThat(userDao.getCount(), is(2));

        userDao.add(user3);
        assertThat(userDao.getCount(), is(3));

    }

    @Test
    public void getAll() throws SQLException {
        userDao.deleteAll();

        // negative test
        List<User> users0 = userDao.getAll();
        assertThat(users0.size(), is(0));

        userDao.add(user1);
        List<User> users1 = userDao.getAll();
        assertThat(users1.size(), is(1));
        checkSameUser(user1, users1.get(0));

        userDao.add(user2);
        List<User> users2 = userDao.getAll();
        assertThat(users2.size(), is(2));
        checkSameUser(user1, users2.get(0));
        checkSameUser(user2, users2.get(1));

        userDao.add(user3);
        List<User> users3 = userDao.getAll();
        assertThat(users3.size(), is(3));
        checkSameUser(user3, users3.get(0)); // user3의 id 값이 알파벳 순으로 가장 빠르므로 getAll()의 첫번째 엘리먼트여야 한다.
        checkSameUser(user1, users3.get(1));
        checkSameUser(user2, users3.get(2));

    }

    private void checkSameUser(User expectedUser, User testUser) {
        assertThat(expectedUser.getId(), is(testUser.getId()));
        assertThat(expectedUser.getName(), is(testUser.getName()));
        assertThat(expectedUser.getPassword(), is(testUser.getPassword()));
        assertThat(expectedUser.getLevel(), is(testUser.getLevel()));
        assertThat(expectedUser.getLogin(), is(testUser.getLogin()));
        assertThat(expectedUser.getRecommend(), is(testUser.getRecommend()));
    }

    @Test(expected = DuplicateKeyException.class)
    public void addDuplicatedKey() {
        userDao.deleteAll();

        userDao.add(user1);
        userDao.add(user1);
    }

    @Test
    public void sqlExceptionTranslate() {
        userDao.deleteAll();

        try {
            userDao.add(user1);
            userDao.add(user1);
        }
        catch(DuplicateKeyException ex) {
            SQLException sqlEx = (SQLException)ex.getCause(); // DuplicatedKeyException 을 발생시킨 cause Exception (즉, CheckedException)을 얻어온다.
            SQLExceptionTranslator set = new SQLErrorCodeSQLExceptionTranslator(this.dataSource); // 코드를 이용한 SQLException 의 전환
            DataAccessException transEx = set.translate(null, null, sqlEx); // SQLExcepion 을 RuntimeException 인 DataAccessException 으로 전환시켜 준다.
            assertThat(transEx, is(DuplicateKeyException.class));
        }
    }

    @Test
    public void update() {
        userDao.deleteAll();

        userDao.add(user1);
        userDao.add(user2);

        user1.setName("오민규");
        user1.setPassword("springno6");
        user1.setLevel(Level.GOLD);
        user1.setLogin(1000);
        user1.setRecommend(999);

        userDao.update(user1);

        User user1update = userDao.get(user1.getId());
        checkSameUser(user1, user1update);

        // update 쿼리의 where 절이 잘 적용되었는지 확인하기 위한 테스트
        User user2same = userDao.get(user2.getId());
        checkSameUser(user2, user2same);

    }

}

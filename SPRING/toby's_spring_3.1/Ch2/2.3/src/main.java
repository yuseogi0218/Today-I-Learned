import org.junit.Before;
import org.junit.runner.JUnitCore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * userDAO 테스트
 */

public class main {

    private UserDao userDao;

    private User user1;
    private User user2;
    private User user3;


    @Before
    public void setUp() {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        this.userDao = context.getBean("userDao", UserDao.class);

        this.user1 = new User("gyumee", "박성철", "springno1");
        this.user2 = new User("leegw700", "이길원", "springno2");
        this.user3 = new User("bumjin", "박범진", "springno3");
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

        assertThat(searchedUser1.getName(), is(user1.getName()));
        assertThat(searchedUser1.getPassword(), is(user1.getPassword()));

        User searchedUser2 = userDao.get(user2.getId());

        assertThat(searchedUser2.getName(), is(user2.getName()));
        assertThat(searchedUser2.getPassword(), is(user2.getPassword()));

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

    @Test(expected = EmptyResultDataAccessException.class)
    public void getUserFailure() throws SQLException {

        userDao.deleteAll();
        assertThat(userDao.getCount(), is(0));

        userDao.get("unknown_id");

    }

}

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * userDAO 테스트
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations = "/test-applicationContext.xml")
////@DirtiesContext // 테스트 메소드에서 애플리케이션 컨텍스트의 구성이나 상태를 변경한다는 것을 테스트 컨텍스트 프레임워크에 알려준다.
public class main {

//    @Autowired
//    private ApplicationContext context;

//    @Autowired
    private UserDao userDao;

    private User user1;
    private User user2;
    private User user3;


    @Before
    public void setUp() {

//        this.userDao = context.getBean("userDao", UserDao.class);
        this.userDao = new UserDao();
        DataSource dataSource = new SingleConnectionDataSource(
                "jdbc:mysql://localhost:3306/testdb?useSSL=false", "root", "2db8ddasf", true
        );

        userDao.setDataSource(dataSource);

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

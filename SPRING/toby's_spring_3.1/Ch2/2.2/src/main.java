import org.junit.runner.JUnitCore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * userDAO 테스트
 */

public class main {

    public static void main(String[] args) {
        JUnitCore.main("springbook.user.dao.main");
    }

    @Test
    public void addAndGet() throws SQLException {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        UserDao userDao = context.getBean("userDao", UserDao.class);

        // insert test
        User user = new User();
        user.setId("Id");
        user.setName("test_name");
        user.setPassword("Password");

        userDao.add(user);

        System.out.println(user.getId() + "등록 성공");

        // select test
        User searchedUser = userDao.get(user.getId());

        assertThat(searchedUser.getName(), is(user.getName()));
        assertThat(searchedUser.getPassword(), is(user.getPassword()));

//        if (!user.getName().equals(searchedUser.getName())) {
//            System.out.println("테스트 실패 (name)");
//        } else if (!user.getPassword().equals(searchedUser.getPassword())) {
//            System.out.println("테스트 실패 (password)");
//        } else {
//            System.out.println("조회 테스트 성공");
//        }
    }
}

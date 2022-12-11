import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import springbook.user.dao.UserDao;
import springbook.user.domain.User;

import java.sql.SQLException;

/**
 * userDAO 테스트
 */

public class main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

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

        System.out.println(searchedUser.getName());
        System.out.println(searchedUser.getPassword());

        System.out.println(searchedUser.getId() + "조회 성공");
    }
}

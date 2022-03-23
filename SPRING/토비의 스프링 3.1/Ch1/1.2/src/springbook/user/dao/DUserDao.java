package springbook.user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DUserDao extends UserDao{
    @Override
    public Connection getConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection 을 가져온다.
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/toby?useSSL=false", "root", "2db8ddasf"
        );

        return c;
    }
}

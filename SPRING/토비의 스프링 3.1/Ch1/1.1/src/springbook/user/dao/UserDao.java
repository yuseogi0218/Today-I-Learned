package springbook.user.dao;

import springbook.user.domain.User;

import java.sql.*;

public class UserDao {

    /**
     * User 데이터 추가
     */
    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection 을 가져온다.
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/toby?useSSL=false", "root", "2db8ddasf"
        );

        // Statement 작성
        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)"
        );
        // parameter 설정
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        // Statement 실행 후 DB 업데이트?
        ps.executeUpdate();

        // 작업 중에 생성된 Connection, Statement 같은 리소스는 역순으로 닫아준다.
        ps.close();
        c.close();

    }

    /**
     * User 데이터 조회
     */
    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Connection 을 가져온다.
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/toby?useSSL=false", "root", "2db8ddasf"
        );

        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?"
        );
        // parameter 설정
        ps.setString(1, id);

        // 쿼리 실행 후 결과값 받음
        ResultSet rs = ps.executeQuery();
        rs.next(); // pointer 이동?

        // 결과값을 정보를 저장할 오브젝트에 옮겨준다.
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        // 작업 중에 생성된 Connection, Statement 같은 리소스는 역순으로 닫아준다.
        rs.close();
        ps.close();
        c.close();

        return user;
    }
}

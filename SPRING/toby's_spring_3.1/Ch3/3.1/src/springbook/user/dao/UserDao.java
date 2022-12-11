package springbook.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import springbook.user.domain.User;

public class UserDao {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void add(User user) throws SQLException {
        Connection c = this.dataSource.getConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id, name, password) values(?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());

        ps.executeUpdate();

        ps.close();
        c.close();
    }

    public User get(String id) throws SQLException {
        Connection c = this.dataSource.getConnection();
        PreparedStatement ps = c
                .prepareStatement("select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();

        User user = null;
        if (rs.next()) {
            user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
        }

        rs.close();
        ps.close();
        c.close();

        if (user == null) {
            throw new EmptyResultDataAccessException(1);
        }
        return user;
    }

    /**
     * User 테이블의 모든 데이터 삭제
     */
    public void deleteAll() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = this.dataSource.getConnection();

            ps = c.prepareStatement("delete from users");

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
            if (ps != null) {
                try {
                    ps.close();
                    // ps.close 에서도 예외처리를 해주는 이유
                    // SQLException이 발생할 수 있기 때문에 이를 잡아줘야 한다.
                    // 그렇지 않으면 Connection 을 close()하지 못하고 메소드를 빠져나갈 수 있다.
                } catch (SQLException e) {

                }
            }

            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    /**
     * User 테이블의 데이터 개수를 반환한다.
     */
    public int getCount() throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            c = this.dataSource.getConnection();

            ps = c.prepareStatement("select count(*) from users");

            rs = ps.executeQuery();
            rs.next();

            int count = rs.getInt(1);

            return count;
        } catch (SQLException e) {
            throw e;
        } finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                }
            }

            if (ps != null) {
                try {
                    ps.close();
                } catch (SQLException e) {

                }
            }

            if (c != null) {
                try {
                    c.close();
                } catch (SQLException e) {

                }
            }

        }
    }
}
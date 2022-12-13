package springbook.user.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import springbook.user.domain.User;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserDaoJdbc implements UserDao{

    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        // JdbcTemplate 의존성 주입
        this.jdbcTemplate = new JdbcTemplate(dataSource);

    }

    private RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setId(rs.getString("id"));
            user.setName(rs.getString("name"));
            user.setPassword(rs.getString("password"));
            return user;
        }
    };

    public void add(final User user) {
        this.jdbcTemplate.update("insert into users(id, name, password) values(?,?,?)", user.getId(), user.getName(), user.getPassword());
    }

    public User get(String id) {
        return this.jdbcTemplate.queryForObject("select * from users where id = ?",
                new Object[]{id}, // SQL 에 바인딩할 파라미터 값. 가변 인자 대신 배열을 사용한다.
                this.userRowMapper
        );
    }

    public List<User> getAll() {
        return this.jdbcTemplate.query(
                "select * from users",
                this.userRowMapper
        );
    }

    /**
     * User 테이블의 모든 데이터 삭제
     */
    public void deleteAll() {
        this.jdbcTemplate.update("delete from users");
    }

    /**
     * User 테이블의 데이터 개수를 반환한다.
     */
    public int getCount() {
        return this.jdbcTemplate.queryForInt("select count(*) from users");

    }


}
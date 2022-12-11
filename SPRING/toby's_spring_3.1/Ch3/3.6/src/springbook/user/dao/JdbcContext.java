package springbook.user.dao;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcContext {

    private DataSource dataSource;

    // DataSource 타입 빈을 DI 받을 수 있게 준비해둔다.
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    // jdbcContextWithStatementStrategy() 메소드의 이름을 변경해준다.
    public void workWithStatementStrategy(StatementStrategy stmt) throws SQLException {
        Connection c = null;
        PreparedStatement ps = null;

        try {
            c = this.dataSource.getConnection();

            ps = stmt.makePreparedStatement(c);

            ps.executeUpdate();
        } catch (SQLException e) {
            throw e;
        } finally {
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

    public void executeSql(final String query, final String...params) throws SQLException {
        workWithStatementStrategy(
                new StatementStrategy() {
                    public PreparedStatement makePreparedStatement(Connection c) throws SQLException {
                        PreparedStatement ps = c.prepareStatement(query);

                        for (int i = 0; i < params.length; i ++) {
                            ps.setString(i + 1, params[i]);
                        }

                        return ps;

                    }
                }
        );
    }
}

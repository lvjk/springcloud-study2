package com.zzw.basedata.service.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zzw.basedata.service.domain.User;

@Repository(value = "useDao")
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return jdbcTemplate.query("select * from users", new UserRowMapper());
	}

	@Transactional(readOnly = true)
	public User findUserById(long id) {
		return jdbcTemplate.queryForObject("select * from users where id=?", new Object[] { id }, new UserRowMapper());
	}

	public User create(final User user) {
		final String sql = "insert into users(id,username,age) values(?,?,?)";
		// KeyHolder holder = new GeneratedKeyHolder();
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setLong(1, user.getId());
				ps.setString(2, user.getUsername());
				ps.setInt(3, user.getAge());
				return ps;
			}
		}/* , holder */);

		// long newUserId = holder.getKey().intValue();
		// user.setId(newUserId);
		return user;
	}

	public void delete(final long id) {
		final String sql = "delete from users where id=?";
		jdbcTemplate.update(sql, new Object[] { id }, new int[] { java.sql.Types.INTEGER });
	}

	public void update(final User user) {
		jdbcTemplate.update("update users set username=?,age=? where id=?",
				new Object[] { user.getUsername(), user.getAge(), user.getId() });
	}
}

class UserRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user = new User();
		user.setId(rs.getLong("id"));
		user.setUsername(rs.getString("username"));
		user.setAge(rs.getInt("age"));
		return user;
	}

}

package com.zzw.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.zzw.web.domain.SysPermission;
import com.zzw.web.domain.SysRole;
import com.zzw.web.domain.UserInfo;

@Repository(value = "useDao")
public class UserRepository {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 通过username查找用户信息
	 * @param username
	 * @return UserInfo
	 */
	public UserInfo findByUsername(String username) {
		return jdbcTemplate.queryForObject("select * from user_info where username = ?", new Object[] { username },
				new UserInfoRowMapper(jdbcTemplate));
	}
}

class UserInfoRowMapper implements RowMapper<UserInfo> {
	private JdbcTemplate jdbcTemplate;

	public UserInfoRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public UserInfo mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserInfo user = new UserInfo();
		user.setName(rs.getString("name"));
		user.setPassword(rs.getString("password"));
		user.setSalt(rs.getString("salt"));
		user.setState(rs.getInt("state"));
		user.setUid(rs.getLong("uid"));
		user.setUsername(rs.getString("username"));
		List<SysRole> roleList = jdbcTemplate.query(
				"SELECT DISTINCT * FROM sys_role JOIN sys_user_role ON sys_role.id = sys_user_role.role_id JOIN user_info ON user_info.uid = sys_user_role.uid WHERE user_info.uid = ?",
				new Object[] { user.getUid() }, new SysRoleRowMapper(jdbcTemplate));
		user.setRoleList(roleList);
		return user;
	}

}

class SysRoleRowMapper implements RowMapper<SysRole> {

	private JdbcTemplate jdbcTemplate;

	public SysRoleRowMapper(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public SysRole mapRow(ResultSet rs, int rowNum) throws SQLException {
		SysRole role = new SysRole();
		role.setId(rs.getLong("id"));
		role.setAvailable(rs.getBoolean("available"));
		role.setDescription(rs.getString("description"));
		role.setRole(rs.getString("role"));
		String sql = "SELECT distinct * FROM sys_permission JOIN sys_role_permission ON sys_permission.id = sys_role_permission.role_id JOIN sys_role ON sys_role.id = sys_role_permission.role_id WHERE sys_role.id = ?";
		List<SysPermission> permissions = jdbcTemplate.query(sql, new Object[] { role.getId() },
				new SysPermissionRowMapper());
		role.setPermissions(permissions);
		return role;
	}

}

class SysPermissionRowMapper implements RowMapper<SysPermission> {
	@Override
	public SysPermission mapRow(ResultSet rs, int rowNum) throws SQLException {
		SysPermission perm = new SysPermission();
		perm.setId(rs.getLong("id"));
		perm.setAvailable(rs.getBoolean("available"));
		perm.setName(rs.getString("name"));
		perm.setParentId(rs.getLong("parent_id"));
		perm.setParentIds(rs.getString("parent_ids"));
		perm.setPermission(rs.getString("permission"));
		perm.setResourceType(rs.getString("resource_type"));
		perm.setUrl(rs.getString("url"));
		return perm;
	}

}
package com.zzwtec.basedata.dao;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.zzwtec.common.bean.basedata.UserCell;

@Repository(value = "userCellDao")
public class UserCellDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * 全查询，一般不推荐使用，除非数据量不大
	 * 
	 * @return
	 */
	@Transactional(readOnly = true)
	public List<UserCell> selectAll() {
		try {			
			return jdbcTemplate.query("select * from user_cell", new UserCellRowMapper());
		} catch (DataAccessException e) {
			throw e;
		}

	}

	/**
	 * 获取一条记录
	 * 
	 * @param id
	 * @return
	 */
	@Transactional(readOnly = true)
	public UserCell selectOne(Serializable id) {
		try {			
			return jdbcTemplate.queryForObject("select * from user_cell where id = ?", new Object[] { id }, new UserCellRowMapper());
		} catch (DataAccessException e) {
			throw e;
		}

	}

	/**
	 * 根据sql获取单表记录
	 * 
	 * @param sql
	 * @param elementType
	 * @return
	 */
	@Transactional(readOnly = true)
	public <T> List<T> selectList(String sql, Class<T> elementType) {
		try {
			return jdbcTemplate.queryForList(sql, elementType);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 根据sql获取单表记录,支持sql预先处理语句参数
	 * 
	 * @param sql
	 * @param params
	 * @param elementType
	 * @return
	 */
	@Transactional(readOnly = true)
	public <T> List<T> selectList(String sql, Object[] params, Class<T> elementType) {
		try {
			return jdbcTemplate.queryForList(sql, params, elementType);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 更新单表数据
	 * 
	 * @param sql
	 * @return
	 */
	public int update(String sql) {
		try {
			return jdbcTemplate.update(sql);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 批量更新单表数据
	 * 
	 * @param sql
	 * @param batchArgs
	 * @return
	 */
	public int[] batchUpdate(String sql) {
		try {
			return jdbcTemplate.batchUpdate(sql);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 更新单表数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int update(String sql, Object... params) {
		try {
			return jdbcTemplate.update(sql, params);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 批量更新单表数据,支持sql预处理语句参数
	 * 
	 * @param sql
	 * @param batchArgs
	 * @return
	 */
	public int[] batchUpdate(String sql, List<Object[]> batchArgs) {
		try {
			return jdbcTemplate.batchUpdate(sql, batchArgs);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 添加单表数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int insert(String sql, Object... params) {
		try {
			if (sql == null || !sql.startsWith("insert")) {
				throw new RuntimeException("不是合法的添加数据sql语句: " + sql);
			}
			return jdbcTemplate.update(sql, params);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 添加单表数据
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public int delete(String sql, Object... params) {
		try {
			if (sql == null || !sql.startsWith("insert")) {
				throw new RuntimeException("不是合法的删除数据sql语句: " + sql);
			}
			return jdbcTemplate.update(sql, params);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 获取 SqlRowSet
	 * 
	 * @param sql
	 * @param args
	 * @return
	 */
	public SqlRowSet selectForRowSet(String sql, Object... args) {
		try {
			return jdbcTemplate.queryForRowSet(sql, args);
		} catch (DataAccessException e) {
			throw e;
		}
	}

	/**
	 * 获取row的数据，一般用于count
	 * 
	 * @param row
	 * @param columnLabel
	 * @return
	 */
	public String getRowColumnValue(SqlRowSet row, String columnLabel) {
		return row.getString(columnLabel);
	}

}

class UserCellRowMapper implements RowMapper<UserCell> {
	@Override
	public UserCell mapRow(ResultSet rs, int rowNum) throws SQLException {
		UserCell bean = new UserCell();		
		bean.setUserId(rs.getString("user_id"));
		bean.setCellId(rs.getString("cell_id"));
		bean.setType(rs.getInt("type"));
		bean.setDeletec(rs.getBoolean("deletec"));
		bean.setRemark(rs.getString("remark"));
		return bean;
	}

}
package io.imfast.webrwd.mapper;

import java.sql.ResultSet;

import io.imfast.webrwd.model.Role;
import io.imfast.webrwd.model.User;

public class UserMapper implements RowMapper<User> {

	@Override
	public User MapRow(ResultSet rs) {
		try {
			User user = new User();
			user.setUserID(rs.getLong("UserID"));
			user.setUsername(rs.getString("Username"));
			user.setPassword(rs.getString("Password"));
			user.setStatus(rs.getInt("Status"));
			/*
			 * user.setCreateDate(rs.getTimestamp("createDate"));
			 * if(rs.getTimestamp("modifyDate") != null) {
			 * user.setModifyDate(rs.getTimestamp("modifyDate")); }
			 * user.setCreateBy(rs.getString("createBy")); if(rs.getString("modifyBy") !=
			 * null) { user.setModifyBy(rs.getString("modifyBy")); }
			 */
			 
			try {
			Role role = new Role();
			role.setRoleName(rs.getString("RoleName"));
			role.setCode(rs.getString("Code"));
			user.setRole(role);
			}catch(Exception e) {
				e.getMessage();
			}
		return user ;
		}catch(Exception e) {
			return null;
		}
	}

}

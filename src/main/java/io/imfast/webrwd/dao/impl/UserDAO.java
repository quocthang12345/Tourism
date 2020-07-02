package io.imfast.webrwd.dao.impl;

import java.util.List;

import io.imfast.webrwd.dao.IUserDAO;
import io.imfast.webrwd.mapper.UserMapper;
import io.imfast.webrwd.model.User;

public class UserDAO extends AbstractDAO<User> implements IUserDAO {

	@Override
	public User FindByUsernamePassStatus(String Username, String Password, Integer Status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS U ");
		sql.append("INNER JOIN role AS R ON U.RoleID = R.RoleID ");
		sql.append("WHERE Username = ? AND Password = ? AND Status = ?");

		List<User> users = query(sql.toString(),new UserMapper(),Username,Password,Status);
		return users.isEmpty() ? null : users.get(0);
	}

	@Override
	public Long Insert(User user) {
		String sql = "INSERT INTO user(Password,Username,Address,Email,Telephone,Birthday,Status,createDate,RoleID,HistoryID) VALUES (?,?,?,?,?,?,?,?,?,?)";
		return Insert(sql, user.getPassword(),user.getUsername(),user.getAddress(),user.getEmail(),user.getTelephone(),user.getBirthday(),1,user.getCreateDate()
				,2,1);
	}

	@Override
	public User FindOne(Long id) {
		String sql = "SELECT * FROM items WHERE UserID = ?";
	    List<User> user = query(sql,new UserMapper(),id);
	    return user.isEmpty() ? null : user.get(0);
	}

}

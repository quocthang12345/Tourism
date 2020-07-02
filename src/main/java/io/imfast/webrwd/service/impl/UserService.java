package io.imfast.webrwd.service.impl;

import java.sql.Timestamp;

import javax.inject.Inject;

import io.imfast.webrwd.dao.IUserDAO;
import io.imfast.webrwd.model.User;
import io.imfast.webrwd.service.IUserService;

public class UserService implements IUserService {

	@Inject
	private IUserDAO userDAO;
	@Override
	public User FindByUsernamePassStatus(String Username, String Password, Integer Status) {
		// TODO Auto-generated method stub
		return userDAO.FindByUsernamePassStatus(Username, Password, Status);
	}
	@Override
	public Long Insert(User user) {
		user.setCreateDate(new Timestamp(System.currentTimeMillis()));
		Long id = userDAO.Insert(user);
		return id;
	}
}

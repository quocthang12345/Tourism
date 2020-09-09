package io.imfast.webrwd.dao;

import io.imfast.webrwd.model.User;

public interface IUserDAO extends GenericDAO<User> {
	User FindByUsernamePassStatus(String Username , String Password , Integer Status);
	Long Insert(User user);
	User FindOne(Long id);
}

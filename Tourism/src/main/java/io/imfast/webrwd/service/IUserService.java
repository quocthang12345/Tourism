package io.imfast.webrwd.service;

import io.imfast.webrwd.model.User;

public interface IUserService {
	User FindByUsernamePassStatus(String Username, String Password, Integer Status);
	Long Insert(User user);
}

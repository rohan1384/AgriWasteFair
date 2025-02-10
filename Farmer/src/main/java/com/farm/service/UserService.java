package com.farm.service;

import com.farm.entity.User;
import com.farm.register.UserModel;

public interface UserService{

	
	 User registerUser(UserModel userModel);
	 
	 User loginUser(String email, String password);
	 
}

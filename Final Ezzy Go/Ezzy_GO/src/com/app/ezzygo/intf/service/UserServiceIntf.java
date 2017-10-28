package com.app.ezzygo.intf.service;

import java.util.List;

import com.app.ezzygo.pojos.UserPojo;

public interface UserServiceIntf {
	UserPojo registerUser(UserPojo user);

	UserPojo validateUser(UserPojo user);

	UserPojo varifyEmail(UserPojo user);

	List<UserPojo> getAgents();

	UserPojo getUserPojo(String email);
	
	UserPojo changeStatus(UserPojo userPojo);
}

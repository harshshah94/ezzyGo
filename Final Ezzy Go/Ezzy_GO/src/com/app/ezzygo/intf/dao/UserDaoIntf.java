package com.app.ezzygo.intf.dao;

import java.util.List;

import com.app.ezzygo.pojos.UserPojo;

public interface UserDaoIntf {

	UserPojo validateUser(String email, String password);

	UserPojo getDetails(String details, String type);

	UserPojo registerUser(UserPojo user);
	
	List<UserPojo> getAgents();
	
	UserPojo getUserPojo(String email);
	
	UserPojo changeStatus(UserPojo userPojo);
}

package com.app.ezzygo.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

import com.app.ezzygo.intf.dao.UserDaoIntf;
import com.app.ezzygo.intf.service.UserServiceIntf;
import com.app.ezzygo.pojos.UserPojo;

import static com.app.ezzygo.utils.EzzyGoConstants.*;
import static com.app.ezzygo.utils.security.SecurityUtils.*;

@Service("dao_based_user_service")
public class UserServiceImpl implements UserServiceIntf {
	@Autowired
	private UserDaoIntf userDaoImpl;

	@Override
	public UserPojo registerUser(UserPojo user) {
		UserPojo userPojo = null;
		try {
			if ((null == userDaoImpl.getDetails(user.getEmail(), EMAIL) && (null == userDaoImpl
					.getDetails(user.getMobile(), MOBILE)))) {
				user.setPassword(getEncrypted(user.getPassword()));

				userPojo = userDaoImpl.registerUser(user);
			} else {
				// throw user defined exception for duplicate email and mobile
				System.out.println("Already Exits");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage() + e.getCause());
		}
		return userPojo;
	}

	@Override
	public UserPojo validateUser(UserPojo user) {
		UserPojo userPojo = null;

		if (null == userDaoImpl.getDetails(user.getEmail(), EMAIL)) {
			// user not registerd yet
			// move to register page or home page
		} else {
			user.setPassword(getEncrypted(user.getPassword()));

			userPojo = userDaoImpl.validateUser(user.getEmail(),
					user.getPassword());
		}
		return userPojo;
	}
	
	@Override
	public UserPojo varifyEmail(UserPojo user)
	{
	
		System.out.println("inside varification of email");	
		return userDaoImpl.getDetails(user.getEmail(), EMAIL);
	}

	@Override
	public List<UserPojo> getAgents() {
		return userDaoImpl.getAgents();
	}

	@Override
	public UserPojo getUserPojo(String email) {
		return userDaoImpl.getUserPojo(email);
				
	}
	
	@Override
	public UserPojo changeStatus(UserPojo userPojo) {
		return userDaoImpl.changeStatus(userPojo);
	}
}

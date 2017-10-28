package com.app.ezzygo.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ezzygo.intf.dao.UserDaoIntf;
import com.app.ezzygo.pojos.UserPojo;
import com.app.ezzygo.utils.EzzyGoConstants;

@Repository
@Transactional
public class UserDaoImpl implements UserDaoIntf {
	// dependency factory

	@Autowired
	private SessionFactory factory;

	// SessionFactory factory=new LocalSessionFactoryBean();

	@Override
	public UserPojo validateUser(String email, String password) {
		return (UserPojo) factory
				.getCurrentSession()
				.createQuery(
						"select u from UserPojo u where u.email = :em and u.password = :pass")
				.setParameter("em", email).setParameter("pass", password)
				.uniqueResult();

	}

	@Override
	public UserPojo registerUser(UserPojo user) {
		factory.getCurrentSession().save(user);
		return user;
	}

	@Override
	public UserPojo getDetails(String details, String type) {
		UserPojo userPojo = null;
		if (type.equals("email")) {
			userPojo = (UserPojo) factory.getCurrentSession().get(
					UserPojo.class, details);
		} else if (type.equals("mobile")) {
			userPojo = (UserPojo) factory
					.getCurrentSession()
					.createQuery(
							"select u from UserPojo u where u.mobile = :mo")
					.setParameter("mo", details).uniqueResult();
		}
		return userPojo;
	}

	@Override
	public List<UserPojo> getAgents() {
		return factory.getCurrentSession()
				.createQuery("from UserPojo where role=:role")
				.setParameter("role", EzzyGoConstants.ADMIN_ROLE).list();
	}

	@Override
	public UserPojo getUserPojo(String email) {

		return (UserPojo) factory.getCurrentSession()
				.get(UserPojo.class, email);
	}

	@Override
	public UserPojo changeStatus(UserPojo userPojo) {
		if (userPojo.getActive().equals("Y"))
			userPojo.setActive("N");
		else
			userPojo.setActive("N");
		
		factory.getCurrentSession().saveOrUpdate(userPojo);
		return userPojo;
	}
}

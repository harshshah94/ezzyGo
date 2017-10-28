package com.app.ezzygo.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ezzygo.intf.dao.BusDaoIntf;
import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.UserPojo;

@Repository
@Transactional
public class BusDaoImpl implements BusDaoIntf {

	@Autowired
	private SessionFactory factory;

	@Override
	public BusPojo addBus(BusPojo busPojo) {
		factory.getCurrentSession().save(busPojo);
		return busPojo;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BusPojo> getBuses(UserPojo agentUserPojo) {
		List<BusPojo> list = factory.getCurrentSession().createQuery(
		// "from BusPojo b where b.agentDetails = :email")
				"select b from BusPojo b where b.agentDetails.email = :email")
				.setParameter("email", agentUserPojo.getEmail()).list();
		return list;
	}

	@Override
	public BusPojo getBus(Long busId) {
		return (BusPojo) factory.getCurrentSession().get(BusPojo.class, busId);
	}

	@Override
	public BusPojo getBus(String passingNumber) {
		return (BusPojo) factory
				.getCurrentSession()
				.createQuery(
						"select b from BusPojo b where b.passingNumber = :passNumber")
				.setParameter("passNumber", passingNumber).uniqueResult();
	}

	@Override
	public BusPojo getBus(String agentEmail, String busName) {
		return (BusPojo) factory
				.getCurrentSession()
				.createQuery(
						"from BusPojo b where b.agentDetails.email = :agentEmail and busName=:busName")
				.setParameter("agentEmail", agentEmail).setParameter("busName", busName).uniqueResult();
	
	}
}
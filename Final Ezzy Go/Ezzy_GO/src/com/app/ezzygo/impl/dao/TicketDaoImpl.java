package com.app.ezzygo.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ezzygo.intf.dao.TicketDaoIntf;
import com.app.ezzygo.pojos.PassengerPojo;
import com.app.ezzygo.pojos.TicketPojo;

@Repository
@Transactional
public class TicketDaoImpl implements TicketDaoIntf {
	@Autowired
	private SessionFactory factory;

	@Override
	public TicketPojo addTicket(TicketPojo ticket) {
		factory.getCurrentSession().save(ticket);
		return ticket;
	}

	@Override
	public boolean addPassengers(List<PassengerPojo> lst) {
		try {
			for (PassengerPojo pp : lst) {
				factory.getCurrentSession().save(pp);
			}
		} catch (Exception e) {
			return false;
		}
		return true;
	}

}

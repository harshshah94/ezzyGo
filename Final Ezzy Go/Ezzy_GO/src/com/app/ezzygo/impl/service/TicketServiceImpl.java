package com.app.ezzygo.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ezzygo.intf.dao.TicketDaoIntf;
import com.app.ezzygo.intf.service.TicketServiceIntf;
import com.app.ezzygo.pojos.PassengerPojo;
import com.app.ezzygo.pojos.TicketPojo;

@Service("dao_based_ticket_service")
public class TicketServiceImpl implements TicketServiceIntf {
	@Autowired
	private TicketDaoIntf ticketDaoImpl;

	@Override
	public TicketPojo addTicket(TicketPojo ticket) {
		return ticketDaoImpl.addTicket(ticket);
	}

	@Override
	public boolean addPassengers(List<PassengerPojo> lst) {
		return ticketDaoImpl.addPassengers(lst);
	}

}

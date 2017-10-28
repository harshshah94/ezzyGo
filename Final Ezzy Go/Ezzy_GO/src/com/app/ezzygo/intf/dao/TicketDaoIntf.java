package com.app.ezzygo.intf.dao;

import java.util.List;

import com.app.ezzygo.pojos.PassengerPojo;
import com.app.ezzygo.pojos.TicketPojo;

public interface TicketDaoIntf {
	TicketPojo addTicket(TicketPojo ticket);
	
	boolean addPassengers(List<PassengerPojo> lst);
}

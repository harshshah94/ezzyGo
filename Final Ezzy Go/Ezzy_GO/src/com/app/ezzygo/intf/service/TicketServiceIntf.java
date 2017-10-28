package com.app.ezzygo.intf.service;

import java.util.List;

import com.app.ezzygo.pojos.PassengerPojo;
import com.app.ezzygo.pojos.TicketPojo;

public interface TicketServiceIntf {
	TicketPojo addTicket(TicketPojo ticket);
	boolean addPassengers(List<PassengerPojo> lst);
}

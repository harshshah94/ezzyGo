package com.app.ezzygo.controllers;

import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ezzygo.intf.service.TicketServiceIntf;
import com.app.ezzygo.intf.service.UserServiceIntf;
import com.app.ezzygo.pojos.LayoutPojo;
import com.app.ezzygo.pojos.PassengerPojo;
import com.app.ezzygo.pojos.TicketPojo;

@Controller
@RequestMapping("/ticket")
public class TicketController {
	@Autowired
	@Qualifier("dao_based_user_service")
	private UserServiceIntf userServiceImpl;

	@Autowired
	@Qualifier("dao_based_ticket_service")
	private TicketServiceIntf ticketServiceImpl;
	
	@RequestMapping(value = "/PassengerInfo", method = RequestMethod.GET)
	public String inputPassengerInfo(Model map) {
		
		return "passengerinfo";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/SubmitPassengers", method = RequestMethod.POST)
	public String submitPassengers(Model map, HttpServletRequest request,
			HttpSession hs) {
		java.util.Enumeration<String> enu = request.getParameterNames();
		List<PassengerPojo> passsengerList = new LinkedList<PassengerPojo>();
		List<LayoutPojo> seatList = (List<LayoutPojo>) hs
				.getAttribute("SeatList");
		TicketPojo ticket = (TicketPojo) hs.getAttribute("ticket");
		int count = 0;
		while (enu.hasMoreElements()) {
			String paramName = (String) enu.nextElement();
			if (paramName.startsWith("name") == true) {
				int pno = Integer.parseInt(paramName.substring(4).toString());
				String name = request.getParameter("name" + pno);
				String gender = request.getParameter("gender" + pno);
				Integer age = Integer.parseInt(request
						.getParameter("age" + pno));
				passsengerList.add(new PassengerPojo(ticket, seatList
						.get(count).getLayoutId(), name, age, gender));
			}
		}
		ticketServiceImpl.addPassengers(passsengerList);
		return "done";
	}

}

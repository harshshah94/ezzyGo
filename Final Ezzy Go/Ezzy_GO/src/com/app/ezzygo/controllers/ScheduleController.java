package com.app.ezzygo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ezzygo.intf.service.BusServiceIntf;
import com.app.ezzygo.intf.service.CityServiceIntf;
import com.app.ezzygo.intf.service.ScheduleServiceIntf;
import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.CityPojo;
import com.app.ezzygo.pojos.SchedulePojo;
import com.app.ezzygo.pojos.UserPojo;

@Controller
@RequestMapping("/schedule")
public class ScheduleController {

	@Autowired
	@Qualifier("dao_based_city_service")
	private CityServiceIntf cityServiceimpl;
	@Autowired
	@Qualifier("dao_based_bus_service")
	private BusServiceIntf busServiceImpl;
	@Autowired
	@Qualifier("dao_based_schedule_service")
	private ScheduleServiceIntf scheduleServiceImpl;

	@RequestMapping(value = "/showAddSchedule", method = RequestMethod.GET)
	public String showAddBusForm(Model map, HttpSession hs) {
		UserPojo userPojo = (UserPojo) hs.getAttribute("loginUser");
		map.addAttribute("cityList", cityServiceimpl.getAllCities());
		map.addAttribute("busList", busServiceImpl.getBuses(userPojo));
		return "addschedule";
	}

	@RequestMapping(value = "/addSchedule", method = RequestMethod.POST)
	public String AddSchedule(Model map, HttpSession hs,
			HttpServletRequest request) throws ParseException {
		System.out.println("IN ADDsCHEDULE");
		UserPojo userPojo = (UserPojo) hs.getAttribute("loginUser");
		CityPojo sourceCityPojo = cityServiceimpl.getCity(request
				.getParameter("sourceCity"));
		CityPojo destinationCityPojo = cityServiceimpl.getCity(request
				.getParameter("destinationCity"));
		BusPojo busPojo = busServiceImpl.getBus(userPojo.getEmail(),
				request.getParameter("bus"));
		System.out.println("departure time : "
				+ request.getParameter("departureTime"));
		System.out
				.println("arrival Time" + request.getParameter("arrivalTime"));
		Integer seatFare = Integer.parseInt(request.getParameter("seatFare"));
		Integer sleepFare = Integer.parseInt(request.getParameter("sleepFare"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd hh:mm");
		Date arrivalTime = sdf.parse(request.getParameter("arrivalTime")
				.replace('T', ' '));
		Date departureTime = sdf.parse(request.getParameter("departureTime")
				.replace('T', ' '));
		SchedulePojo schedulePojo = new SchedulePojo(busPojo, sourceCityPojo,
				destinationCityPojo, departureTime, arrivalTime, seatFare,
				sleepFare);
		scheduleServiceImpl.addSchedule(schedulePojo);
		return "done";
	}

}

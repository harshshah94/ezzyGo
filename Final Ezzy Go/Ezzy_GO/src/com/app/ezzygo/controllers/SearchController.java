package com.app.ezzygo.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.app.ezzygo.intf.service.BusServiceIntf;
import com.app.ezzygo.intf.service.CityServiceIntf;
import com.app.ezzygo.intf.service.LayoutServiceIntf;
import com.app.ezzygo.intf.service.ScheduleServiceIntf;
import com.app.ezzygo.pojos.CityPojo;
import com.app.ezzygo.pojos.SchedulePojo;

@Controller
@RequestMapping("/search")
public class SearchController {
	@Autowired
	@Qualifier("dao_based_city_service")
	private CityServiceIntf cityServiceimpl;
	@Autowired
	@Qualifier("dao_based_bus_service")
	private BusServiceIntf busServiceImpl;
	@Autowired
	@Qualifier("dao_based_schedule_service")
	private ScheduleServiceIntf scheduleServiceImpl;
	@Autowired
	@Qualifier("dao_based_city_service")
	private CityServiceIntf cityserviceImpl;
	@Autowired
	@Qualifier("dao_based_layout_service")
	private LayoutServiceIntf layoutServiceImpl;

	@SuppressWarnings("deprecation")
	@RequestMapping(value = "/SearchSchedule", method = RequestMethod.GET)
	public String searchSchedule(Model map, HttpServletRequest request,
			HttpSession hs) throws ParseException {
		CityPojo sourceCity = cityserviceImpl.getCity(request
				.getParameter("sourceCity"));
		CityPojo destinationCity = cityserviceImpl.getCity(request
				.getParameter("destinationCity"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		Date date = sdf.parse(request.getParameter("date"));
		Integer seatsRequired = Integer.parseInt(request
				.getParameter("seatsRequired"));
		Date d = new Date();
		System.out.println(d.toString());
		if (date.getDay() == d.getDay() && date.getMonth() == d.getMonth()
				&& date.getYear() == d.getYear()) {
			date = d;
			System.out.println("today's date" + date);
		}
		List<SchedulePojo> lst = scheduleServiceImpl.search(sourceCity,
				destinationCity, date);
		hs.setAttribute("scheduleData", lst);
		hs.setAttribute("seatsRequired", seatsRequired);
		hs.setAttribute("sourceCity", sourceCity);
		hs.setAttribute("destinationCity", destinationCity);
		map.addAttribute("schedule", new SchedulePojo());
		return "busList";
	}

	@RequestMapping(value = "/ViewSeats", method = RequestMethod.POST)
	public String viewSeats(
			@Valid @ModelAttribute("schedule") SchedulePojo schedule,
			Model map, HttpServletRequest request, HttpSession hs)
			throws ParseException {
		schedule = scheduleServiceImpl.getSchedule(schedule.getRouteId());
		hs.setAttribute("currentSchedule", schedule);
		System.out.println(schedule.getBusDetail().getBusName());
		hs.setAttribute("busLayout",
				layoutServiceImpl.getLayout(schedule.getBusDetail()));
		return "viewseats";
	}

}

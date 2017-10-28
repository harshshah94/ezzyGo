package com.app.ezzygo.controllers;

import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.app.ezzygo.intf.service.BusServiceIntf;
import com.app.ezzygo.intf.service.LayoutServiceIntf;
import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.LayoutPojo;
import com.app.ezzygo.pojos.UserPojo;

@Controller
@RequestMapping("/bus")
public class BusController {

	@Autowired
	@Qualifier("dao_based_bus_service")
	private BusServiceIntf busServiceImpl;
	@Autowired
	@Qualifier("dao_based_layout_service")
	private LayoutServiceIntf layoutServiceImpl;

	@RequestMapping(value = "/showAddBus", method = RequestMethod.GET)
	public String showAddBusForm(Model map) {
		map.addAttribute("busModel", new BusPojo());
		return "addbus";
	}

	@RequestMapping(value = "/showlayout", method = RequestMethod.POST)
	public String processAddBusForm(
			@Valid @ModelAttribute("busModel") BusPojo busPojo,
			BindingResult res, HttpSession hs, Model map,
			RedirectAttributes attr, HttpServletRequest request) {

		if (busServiceImpl.validatePassingNumber(busPojo.getPassingNumber())) {
			UserPojo u = (UserPojo) hs.getAttribute("loginUser");
			busPojo.setAgentDetails(u);
			hs.setAttribute("bus", busPojo);
			return "showlayout";
		} else {
			System.out.println("stray on same page addd eroee passing exist");
			// stray on same page addd eroee passing exist
			return "showLayout";

		}
	}

	@RequestMapping(value = "/addLayoutAndBus", method = RequestMethod.GET)
	public String done(HttpSession hs, Model map, HttpServletRequest request) {
		BusPojo busPojo = (BusPojo) hs.getAttribute("bus");
		java.util.Enumeration<String> enu = request.getParameterNames();
		Set<LayoutPojo> set = new HashSet<LayoutPojo>();
		while (enu.hasMoreElements()) {
			String paramName = (String) enu.nextElement();
			LayoutPojo layoutPojo = null;
			if (paramName.charAt(0) == 'U' || paramName.charAt(0) == 'L') {
				layoutPojo = new LayoutPojo(busPojo, Integer.parseInt(Character
						.toString(paramName.charAt(3))),
						request.getParameter(paramName),
						Integer.parseInt((Character.toString(paramName
								.charAt(1)))), request.getParameter("seatType"
								+ paramName.charAt(3)),
						Character.toString(paramName.charAt(0)));
				set.add(layoutPojo);
			}

		}
		busServiceImpl.addBus(busPojo);
		for (LayoutPojo l : set) {
			layoutServiceImpl.addLayout(l);
		}
		return "done";
	}
}

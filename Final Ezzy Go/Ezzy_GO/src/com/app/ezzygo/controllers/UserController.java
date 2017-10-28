package com.app.ezzygo.controllers;

import java.util.List;

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

import com.app.ezzygo.intf.service.CityServiceIntf;
import com.app.ezzygo.intf.service.UserServiceIntf;
import com.app.ezzygo.pojos.SchedulePojo;
import com.app.ezzygo.pojos.UserPojo;
import com.app.ezzygo.utils.EzzyGoConstants;
import com.app.ezzygo.utils.smtp.SmtpUtils;

import static com.app.ezzygo.utils.EzzyGoConstants.*;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	@Qualifier("dao_based_user_service")
	private UserServiceIntf userServiceImpl;

	@Autowired
	@Qualifier("dao_based_city_service")
	private CityServiceIntf cityserviceImpl;

	@RequestMapping(value = "/goToHome", method = RequestMethod.GET)
	public String showHomePage(Model map, HttpSession hs) {

		UserPojo userPojo = (UserPojo) hs.getAttribute("loginUser");

		map.addAttribute("scheduleModel", new SchedulePojo());

		hs.setAttribute("cityList", cityserviceImpl.getAllCities());

		if ((userPojo != null)
				&& (userPojo.getRole().equals(EzzyGoConstants.ADMIN_ROLE)))
			return "homeadmin";
		else if ((userPojo != null)
				&& (userPojo.getRole().equals(EzzyGoConstants.AGENT_ROLE)))
			return "homeagent";
		else
			return "home";
	}

	@RequestMapping(value = "/showCustomerRegister", method = RequestMethod.GET)
	public String showCustomerRegisterForm(Model map, HttpSession hs) {
		hs.setAttribute("registerationRole", CUST_ROLE);
		map.addAttribute("userModel", new UserPojo());
		return "registeruser";
	}

	@RequestMapping(value = "/showAgentRegister", method = RequestMethod.GET)
	public String showRegisterForm(Model map, HttpSession hs) {
		hs.setAttribute("registerationRole", AGENT_ROLE);
		map.addAttribute("userModel", new UserPojo());
		return "registeruser";
	}

	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String processRegisterForm(
			@Valid @ModelAttribute("userModel") UserPojo userPojo,
			BindingResult res, HttpSession hs, Model map,
			RedirectAttributes attr) {

		UserPojo userPojo2 = null;

		userPojo.setRole((String) hs.getAttribute("registerationRole"));

		if (res.hasFieldErrors()) {
			map.addAttribute("userModel", userPojo);

			System.out.println("P.L errors in register");

			return "registeruser";
		}

		try {
			userPojo2 = userServiceImpl.registerUser(userPojo);
		} catch (Exception e) {

			System.out.println(e.getMessage());

			map.addAttribute("msgToSignUp", "Email already exists...");

			return "registeruser";
		}

		hs.setAttribute("loginUser", userPojo2);

		hs.setAttribute("loginRole", userPojo2.getRole());

		map.addAttribute("scheduleModel", new SchedulePojo());

		hs.setAttribute("cityList", cityserviceImpl.getAllCities());

		map.addAttribute("msg",
				"Register Successfully....<br>&nbsp;&nbsp;&nbsp;&nbsp;Your Registration Id:"
						+ userPojo2.getEmail());

		return "home";
	}

	@RequestMapping(value = "/showLogin", method = RequestMethod.GET)
	public String showLoginForm(Model map) {
		map.addAttribute("userModel", new UserPojo());
		return "loginuser";
	}

	@RequestMapping(value = "/invalidate", method = RequestMethod.GET)
	public String invalidateUserPassThrough(HttpSession hs) {
		hs.invalidate();
		return "home";
	}

	@RequestMapping(value = "/loginUser", method = RequestMethod.POST)
	public String processLoginForm(
			@Valid @ModelAttribute("userModel") UserPojo userPojo,
			BindingResult res, HttpSession hs, Model map,
			RedirectAttributes attr) {

		UserPojo userPojo2 = userServiceImpl.validateUser(userPojo);

		if (null == userPojo2) {
			map.addAttribute("msg", "Invalid username or password...");
			return "loginuser";
		}
		hs.setAttribute("loginUser", userPojo2);

		hs.setAttribute("loginRole", userPojo2.getRole());

		map.addAttribute("scheduleModel", new SchedulePojo());

		hs.setAttribute("cityList", cityserviceImpl.getAllCities());

		if (userPojo2.getRole().equals((EzzyGoConstants.CUST_ROLE))) {

			return "home";
		} else if (userPojo2.getRole().equals((EzzyGoConstants.ADMIN_ROLE))) {

			return "homeadmin";
		} else if (userPojo2.getRole().equals((EzzyGoConstants.AGENT_ROLE))) {

			return "homeagent";
		}
		return "loginuser";
	}

	@RequestMapping(value = "/forgot", method = RequestMethod.GET)
	public String showForgotPage(Model map) {
		map.addAttribute("userModel", new UserPojo());
		return "forgot";
	}

	@RequestMapping(value = "/varifyEmail", method = RequestMethod.GET)
	public String processForgotPassword(
			@Valid @ModelAttribute("userModel") UserPojo userPojo,
			BindingResult res, HttpSession hs, Model map,
			RedirectAttributes attr) {

		UserPojo userPojo3 = null;
		System.out.println("In Process Forgot User Password");
		try {
			userPojo3 = userServiceImpl.varifyEmail(userPojo);
			if (null == userPojo3) {
				map.addAttribute("msg123", "Invalid username...");
				return "forgot";
			} else {
				if (SmtpUtils.sendEmail(userPojo3.getEmail())) {
					hs.setAttribute("forgotPass",
							"Your password send to your email address..");
					return "loginuser";
				} else
					hs.setAttribute("forgotPass",
							"Your password send to your email address..");
				return "sendEmail";
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "forgot";
		}
	}

	@RequestMapping(value = "/AgentList", method = RequestMethod.GET)
	public String showAgentList(Model map, HttpSession hs) {
		hs.setAttribute("agentList", userServiceImpl.getAgents());
		return "agentlist";
	}

	@RequestMapping(value = "/ActivateAgent", method = RequestMethod.GET)
	public String activateAgent(Model map, HttpSession hs,
			HttpServletRequest request) {
		UserPojo userPojo = userServiceImpl.getUserPojo(request
				.getParameter("agentEmail"));
		userServiceImpl.changeStatus(userPojo);
		List<UserPojo> agentList = (List<UserPojo>) hs
				.getAttribute("agentList");
		agentList.remove(userPojo);
		agentList.add(userPojo);
		return "agentlist";
	}

}

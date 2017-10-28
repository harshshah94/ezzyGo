package com.app.ezzygo.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ezzygo.intf.dao.BusDaoIntf;
import com.app.ezzygo.intf.service.BusServiceIntf;
import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.UserPojo;

@Service("dao_based_bus_service")
public class BusServiceImpl implements BusServiceIntf {
	
	@Autowired
	private BusDaoIntf busDaoImpl;

	@Override
	public BusPojo addBus(BusPojo bus) {
		BusPojo busPojo = null;
		if (null == busDaoImpl.getBus(bus.getPassingNumber())) {
			busPojo = busDaoImpl.addBus(bus);
		} else {
			// throw user defined exception for duplicate email and mobile
			System.out.println("Already Exits");
		}
		return busPojo;
	}

	@Override
	public List<BusPojo> getBuses(UserPojo agentUserPojo) {
		return busDaoImpl.getBuses(agentUserPojo);
	}

	@Override
	public BusPojo getBus(Long busId) {
		return busDaoImpl.getBus(busId);
	}

	@Override
	public Boolean validatePassingNumber(String passingNumber) {
		if (null == busDaoImpl.getBus(passingNumber)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public BusPojo getBus(String agentEmail, String busName) {
		return busDaoImpl.getBus(agentEmail, busName);
	}
}

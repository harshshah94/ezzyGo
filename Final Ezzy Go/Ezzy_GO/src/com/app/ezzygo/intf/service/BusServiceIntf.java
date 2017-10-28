package com.app.ezzygo.intf.service;

import java.util.List;

import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.UserPojo;

public interface BusServiceIntf {

	BusPojo addBus(BusPojo bus);

	List<BusPojo> getBuses(UserPojo agentUserPojo);

	BusPojo getBus(Long busId);

	Boolean validatePassingNumber(String passingNumber);
	
	BusPojo getBus(String agentEmail,String busName);

}

package com.app.ezzygo.intf.dao;

import java.util.List;

import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.UserPojo;

public interface BusDaoIntf {

	BusPojo addBus(BusPojo busPojo);

	List<BusPojo> getBuses(UserPojo agentUserPojo);

	BusPojo getBus(Long busId);

	BusPojo getBus(String passingNumber);
	
	BusPojo getBus(String agentEmail,String busName);

}

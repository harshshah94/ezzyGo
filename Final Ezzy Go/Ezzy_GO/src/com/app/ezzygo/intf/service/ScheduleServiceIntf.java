package com.app.ezzygo.intf.service;

import java.util.Date;
import java.util.List;

import com.app.ezzygo.pojos.CityPojo;
import com.app.ezzygo.pojos.SchedulePojo;

public interface ScheduleServiceIntf {

	SchedulePojo addSchedule(SchedulePojo schedule);
	
	List<SchedulePojo>  search(CityPojo sourceCity,CityPojo destinationCity,Date date);
	
	SchedulePojo getSchedule(Long routeId);
}

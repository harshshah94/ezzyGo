package com.app.ezzygo.impl.service;

import java.util.Date;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ezzygo.intf.dao.ScheduleDaoIntf;
import com.app.ezzygo.intf.service.ScheduleServiceIntf;
import com.app.ezzygo.pojos.CityPojo;
import com.app.ezzygo.pojos.SchedulePojo;

@Service("dao_based_schedule_service")
public class ScheduleServiceImpl implements ScheduleServiceIntf {

	@Autowired
	private ScheduleDaoIntf scheduleDaoImpl;

	@Override
	public SchedulePojo addSchedule(SchedulePojo schedule) {
		return scheduleDaoImpl.addSchedule(schedule);
	}

	@Override
	public List<SchedulePojo> search(CityPojo sourceCity,
			CityPojo destinationCity, Date date) {
		return scheduleDaoImpl.search(sourceCity, destinationCity, date);
	}

	@Override
	public SchedulePojo getSchedule(Long routeId) {
		return scheduleDaoImpl.getSchedule(routeId);
	}
	
}

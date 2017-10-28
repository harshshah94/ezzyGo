package com.app.ezzygo.impl.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ezzygo.intf.dao.ScheduleDaoIntf;
import com.app.ezzygo.pojos.CityPojo;
import com.app.ezzygo.pojos.SchedulePojo;

@Repository
@Transactional
public class ScheduleDaoImpl implements ScheduleDaoIntf {

	@Autowired
	private SessionFactory session;

	@Override
	public SchedulePojo addSchedule(SchedulePojo schedule) {
		session.getCurrentSession().persist(schedule);
		return schedule;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SchedulePojo> search(CityPojo sourceCity,
			CityPojo destinationCity, Date date) {
		System.out.println(sourceCity.getCityId());
		System.out.println(destinationCity.getCityId());
		System.out.println(date);
		List<SchedulePojo> lst = session
				.getCurrentSession()
				.createQuery(
						"from SchedulePojo where sourceCity.id=:sourceCity and destinationCity.id=:destinationCity and trunc(departureTime)=trunc(:date)")
				.setParameter("sourceCity", sourceCity.getCityId())
				.setParameter("destinationCity", destinationCity.getCityId())
				.setParameter("date", date).list();
		return lst;
	}

	@Override
	public SchedulePojo getSchedule(Long routeId) {
		return (SchedulePojo)session.getCurrentSession().get(SchedulePojo.class,routeId);
	}
}

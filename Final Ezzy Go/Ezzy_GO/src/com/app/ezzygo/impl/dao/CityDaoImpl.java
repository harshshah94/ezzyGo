package com.app.ezzygo.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ezzygo.intf.dao.CityDaoIntf;
import com.app.ezzygo.pojos.CityPojo;

@Repository
@Transactional
public class CityDaoImpl implements CityDaoIntf {
	@Autowired
	private SessionFactory factory;

	@SuppressWarnings("unchecked")
	@Override
	public List<CityPojo> getAllCities() {
		//addCity(new CityPojo("city1", "state1"));
		List<CityPojo> lst = factory.getCurrentSession()
				.createQuery("select c from CityPojo c").list();
		System.out.println("lst " + lst);
		return lst;
	}

	@Override
	public CityPojo addCity(CityPojo citypojo) {
		factory.getCurrentSession().save(citypojo);
		return citypojo;
	}

	@Override
	public CityPojo getCity(Long cityId) {
		return (CityPojo) factory.getCurrentSession().load(CityPojo.class,
				cityId);
	}

	@Override
	public CityPojo getCity(String cityName) {
		return  (CityPojo) factory.getCurrentSession().createQuery("from CityPojo where cityName = :cityName").setParameter("cityName", cityName).uniqueResult();
	}

}

package com.app.ezzygo.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ezzygo.intf.dao.CityDaoIntf;
import com.app.ezzygo.intf.service.CityServiceIntf;
import com.app.ezzygo.pojos.CityPojo;

@Service("dao_based_city_service")
public class CityServiceImpl implements CityServiceIntf {

	@Autowired
	private CityDaoIntf cityDaoImpl;

	@Override
	public List<CityPojo> getAllCities() {
		return cityDaoImpl.getAllCities();
	}

	@Override
	public CityPojo addCity(CityPojo cityPojo) {
		return cityDaoImpl.addCity(cityPojo);
	}

	@Override
	public CityPojo getCity(Long cityId) {
		return cityDaoImpl.getCity(cityId);
	}

	@Override
	public CityPojo getCity(String cityName) {
		return cityDaoImpl.getCity(cityName);
	}
}

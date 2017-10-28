package com.app.ezzygo.intf.dao;

import java.util.List;

import com.app.ezzygo.pojos.CityPojo;

public interface CityDaoIntf {
	List<CityPojo> getAllCities();
	CityPojo addCity(CityPojo citypojo);
	CityPojo getCity(Long cityId);
	CityPojo getCity(String cityName);
}

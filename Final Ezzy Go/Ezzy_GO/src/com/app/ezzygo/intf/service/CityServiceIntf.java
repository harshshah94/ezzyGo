package com.app.ezzygo.intf.service;

import java.util.List;

import com.app.ezzygo.pojos.CityPojo;

public interface CityServiceIntf {
	List<CityPojo> getAllCities();
	CityPojo addCity(CityPojo cityPojo);
	CityPojo getCity(Long cityId);
	CityPojo getCity(String cityName);
}

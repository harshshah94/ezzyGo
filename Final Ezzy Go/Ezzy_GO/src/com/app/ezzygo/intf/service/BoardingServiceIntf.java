package com.app.ezzygo.intf.service;

import java.util.List;

import com.app.ezzygo.pojos.BoardingPojo;
import com.app.ezzygo.pojos.CityPojo;

public interface BoardingServiceIntf {
	BoardingPojo addBoarding(BoardingPojo boardingPojo);
	List<BoardingPojo> getBoardingPoints(CityPojo cityPojo);
}

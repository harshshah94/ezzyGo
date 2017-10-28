package com.app.ezzygo.intf.dao;

import java.util.List;

import com.app.ezzygo.pojos.BoardingPojo;
import com.app.ezzygo.pojos.CityPojo;

public interface BoardingDaoIntf {
	
	BoardingPojo addBoarding(BoardingPojo boardingPojo);
	List<BoardingPojo> getBoardingPoints(CityPojo cityPojo);
}

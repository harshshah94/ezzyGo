package com.app.ezzygo.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ezzygo.intf.dao.BoardingDaoIntf;
import com.app.ezzygo.intf.service.BoardingServiceIntf;
import com.app.ezzygo.pojos.BoardingPojo;
import com.app.ezzygo.pojos.CityPojo;

@Service("dao_based_boarding_service")
public class BoardingServiceImpl implements BoardingServiceIntf {

	@Autowired
	private BoardingDaoIntf boardingDaoImpl;

	@Override
	public BoardingPojo addBoarding(BoardingPojo boardingPojo) {
			return boardingDaoImpl.addBoarding(boardingPojo);
	}

	@Override
	public List<BoardingPojo> getBoardingPoints(CityPojo cityPojo) {
		return boardingDaoImpl.getBoardingPoints(cityPojo);
	}
	

}

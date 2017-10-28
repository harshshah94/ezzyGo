package com.app.ezzygo.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ezzygo.intf.dao.BoardingDaoIntf;
import com.app.ezzygo.pojos.BoardingPojo;
import com.app.ezzygo.pojos.CityPojo;

@Repository
@Transactional
public class BoardingDaoImpl implements BoardingDaoIntf {
	@Autowired
	private SessionFactory factory;

	@Override
	public BoardingPojo addBoarding(BoardingPojo boardingPojo) {
		factory.getCurrentSession().save(boardingPojo);
		return boardingPojo;
	}

	@Override
	public List<BoardingPojo> getBoardingPoints(CityPojo cityPojo) {
		factory.getCurrentSession()
				.createQuery(
						"select b from BoaringPojo b where b.cityDetail = :city")
				.setParameter("city", cityPojo).list();
		return null;
	}
}

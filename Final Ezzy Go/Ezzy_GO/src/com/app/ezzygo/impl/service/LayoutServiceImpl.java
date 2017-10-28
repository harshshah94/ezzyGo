package com.app.ezzygo.impl.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.ezzygo.intf.dao.LayoutDaoIntf;
import com.app.ezzygo.intf.service.LayoutServiceIntf;
import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.LayoutPojo;

@Service("dao_based_layout_service")
public class LayoutServiceImpl implements LayoutServiceIntf {

	@Autowired
	private LayoutDaoIntf layoutDaoImpl;
	
	@Override
	public LayoutPojo addLayout(LayoutPojo layout) {
		return layoutDaoImpl.addLayout(layout);
				
	}

	@Override
	public List<LayoutPojo> getLayout(BusPojo busPojo) {		
		return layoutDaoImpl.getLayout(busPojo);
	}

}

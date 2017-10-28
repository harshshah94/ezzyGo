package com.app.ezzygo.intf.service;

import java.util.List;

import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.LayoutPojo;

public interface LayoutServiceIntf {

	LayoutPojo addLayout(LayoutPojo layout);
	
	List<LayoutPojo> getLayout(BusPojo busPojo);
}

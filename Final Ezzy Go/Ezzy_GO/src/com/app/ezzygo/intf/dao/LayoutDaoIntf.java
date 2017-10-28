package com.app.ezzygo.intf.dao;

import java.util.List;

import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.LayoutPojo;

public interface LayoutDaoIntf {

	LayoutPojo addLayout(LayoutPojo layout);

	List<LayoutPojo> getLayout(BusPojo busPojo);
}
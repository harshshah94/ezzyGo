package com.app.ezzygo.impl.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.ezzygo.intf.dao.LayoutDaoIntf;
import com.app.ezzygo.pojos.BusPojo;
import com.app.ezzygo.pojos.LayoutPojo;

@Repository
@Transactional
public class LayoutDaoImpl implements LayoutDaoIntf {

	@Autowired
	private SessionFactory factory;

	@Override
	public LayoutPojo addLayout(LayoutPojo layout) {
		factory.getCurrentSession().save(layout);
		return layout;
	}
	/*criteria = session.createCriteria(Child.class);
	criteria.add(Restrictions.eq("parent", parent));
	List<Child> children = criteria.list();*/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<LayoutPojo> getLayout(BusPojo busPojo) {
		List<LayoutPojo> lst = factory.getCurrentSession().createCriteria(LayoutPojo.class).add(Restrictions.eq("busDetail",busPojo)).list();
		System.out.println(lst.get(0).getSeatName());
		return lst;
	}
	
}

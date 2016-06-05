package com.dreamchain.skeleton.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreamchain.skeleton.dao.ImageInfoDao;
import com.dreamchain.skeleton.dao.PiciDao;
import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.Pici;

@Repository
@Transactional
public class PiciDaoImpl implements PiciDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Pici> query() {
		
		return sessionFactory.getCurrentSession().createQuery("FROM Pici ORDER BY id").list();
	}
	
	
	@Override
	public void save(Pici pici) {
		sessionFactory.getCurrentSession().merge(pici);

	}


	@Override
	public int count() {
		String hql = "select count(*)  from Pici";
		 Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		 int n = ((Long) query.iterate().next()).intValue();
		 return n;
	}


	@Override
	public List<Pici> find(int start, int pagesize) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Pici as a");
		query.setFirstResult(start);
		query.setMaxResults(pagesize);
		List<Pici> list = query.list();
		return list;
	}

}

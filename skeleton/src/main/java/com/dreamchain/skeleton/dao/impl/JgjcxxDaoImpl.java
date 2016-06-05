package com.dreamchain.skeleton.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.skeleton.dao.JgjcxxDao;
import com.dreamchain.skeleton.model.Jgjcxx;

@Repository
@Transactional
public class JgjcxxDaoImpl implements JgjcxxDao {

	@Autowired
	private SessionFactory sessionFactory;
	@Override
	public Jgjcxx get(Long id) {
		 return (Jgjcxx) sessionFactory.getCurrentSession().get(Jgjcxx.class, id);
	}

	@Override
	public void delete(Jgjcxx jgjcxx) {
		sessionFactory.getCurrentSession().delete(jgjcxx);
		
	}

	@Override
	public void save(Jgjcxx jgjcxx) {
		sessionFactory.getCurrentSession().merge(jgjcxx);
		
	}

	@Override
	public List<Jgjcxx> findByName(String name) {
		return sessionFactory.getCurrentSession().createQuery(
				"FROM Jgjcxx j WHERE j.jg_yw = :jg_yw ")
			.setString("jg_yw", name).list();
	}

	@Override
	public List<Jgjcxx> find(int start, int pagesize) {
		Query query = sessionFactory.getCurrentSession().createQuery("from Jgjcxx as a");
		query.setFirstResult(start);
		query.setMaxResults(pagesize);
		List<Jgjcxx> list = query.list();
		return list;
	}
	
	@Override
	public int  count(){
		String hql = "select count(*)  from Jgjcxx";
		 Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		 int n = ((Long) query.iterate().next()).intValue();
		 return n;	
	}

}

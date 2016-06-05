package com.dreamchain.skeleton.dao.impl;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.skeleton.dao.UserDao;
import com.dreamchain.skeleton.model.PageBean;
import com.dreamchain.skeleton.model.User;
import com.gargoylesoftware.htmlunit.Page;

@Repository
@Transactional
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User get(Long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	@Override
	public void delete(User user) {
		sessionFactory.getCurrentSession().delete(user);
	}

	@Override

	public List<User> findAll() {
		return sessionFactory.getCurrentSession().createQuery(
				"FROM User ORDER BY id")
			.list();
	}

	@Override
	public void save(User user) {
		sessionFactory.getCurrentSession().merge(user);
		
	}

	@Override
	public User findByName(String name) {
		return (User)sessionFactory.getCurrentSession().createQuery(
				"FROM User u WHERE u.name = :name ")
			.setString("name", name).uniqueResult();
	}
	@Override
	public int  count(){
		String hql = "select count(*)  from User";
		 Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		 int n = ((Long) query.iterate().next()).intValue();
		 return n;	
	}
	@Override 
	public List<User> find(int start, int pagesize){
		Query query = sessionFactory.getCurrentSession().createQuery("from User as a");
		query.setFirstResult(start);
		query.setMaxResults(pagesize);
		List<User> list = query.list();
		return list;
	}
	
	@Override
	public User findByNameAndPassword(String name,String password){
		return (User)sessionFactory.getCurrentSession().createQuery("from User u where u.password = :password and u.name = :name").setString("password",password).setString("name", name).uniqueResult();
		//return (User) query.uniqueResult();
	}
}

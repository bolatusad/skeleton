package com.dreamchain.skeleton.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.dreamchain.skeleton.dao.ImageTagDao;
import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.ImageTag;

@Repository
@Transactional
public class ImageTagDaoImpl implements ImageTagDao {
	
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    public void add(ImageTag image_tag){
      sessionFactory.getCurrentSession().save(image_tag);
    
    	
    }

	@Override
	public List<ImageTag> find(int start, int pagesize) {
		Query query = sessionFactory.getCurrentSession().createQuery("from ImageTag as a");
		query.setFirstResult(start);
		query.setMaxResults(pagesize);
		List<ImageTag> list = query.list();
		return list;
	}

	@Override
	public int count() {
		String hql = "select count(*)  from ImageTag";
		 Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		 int n = ((Long) query.iterate().next()).intValue();
		 return n;
	}
}

package com.dreamchain.skeleton.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.dreamchain.skeleton.dao.ImageInfoDao;
import com.dreamchain.skeleton.model.ImageInfo;

@Repository
@Transactional
public class ImageInfoDaoImpl implements ImageInfoDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ImageInfo> query3() {
		// TODO Auto-generated method stub
		return sessionFactory.getCurrentSession().createQuery("FROM ImageInfo ORDER BY id").list();
		//return sessionFactory.openSession().createQuery(
		//		"FROM image_info ORDER BY id")
		//	.list();
	}

	@Override
	public List<ImageInfo> test3() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update_tag_times(Long id) {
		org.hibernate.Session ses=sessionFactory.openSession();
		ImageInfo image_info1=(ImageInfo) ses.load(ImageInfo.class, id);
		//System.out.println("打印反馈"+image_info1.getId());
		int n=image_info1.getTag_times();
		image_info1.setTag_times(n+1);
		ses.flush();
		
	}

	@Override
	public ImageInfo get(Long id) {
		return (ImageInfo) sessionFactory.getCurrentSession().get(ImageInfo.class, id);
	}

	@Override
	public void delete(ImageInfo imageInfo) {
		sessionFactory.getCurrentSession().delete(imageInfo);
	}

	@Override
	public List<ImageInfo> find(int start, int pagesize) {
		Query query = sessionFactory.getCurrentSession().createQuery("from ImageInfo as a");
		query.setFirstResult(start);
		query.setMaxResults(pagesize);
		List<ImageInfo> list = query.list();
		return list;
	}

	@Override
	public int count() {
		String hql = "select count(*)  from ImageInfo";
		 Query query =  sessionFactory.getCurrentSession().createQuery(hql);
		 int n = ((Long) query.iterate().next()).intValue();
		 return n;
	}

	@Override
	public ImageInfo findByName(String name) {
		return (ImageInfo) sessionFactory.getCurrentSession().createQuery("FROM ImageInfo WHERE g = :name ").setString("name", name).uniqueResult();
	}

	@Override
	public void save(ImageInfo imageInfo) {
		sessionFactory.getCurrentSession().merge(imageInfo);
	}

	@Override
	public void findImages(String start, String end, int num,int piciMax) {
		Object[] imageIds ;
		int count = 0;
		String hql = "SELECT i.id FROM ImageInfo i WHERE i.pici = 0 ";
		imageIds = sessionFactory.getCurrentSession().createQuery(hql).list().toArray();
		for(Object o : imageIds){
			ImageInfo image = (ImageInfo) sessionFactory.getCurrentSession()
					.createQuery("FROM ImageInfo i WHERE i.id = ?")
					.setString(0, o.toString())
					.list().get(0);
			String date = image.getG().substring(1, 9);
			if( start.compareTo(date) <=0 && end.compareTo(date) >0){
				image.setPici(piciMax);
				sessionFactory.getCurrentSession()
				.createQuery("UPDATE ImageInfo i SET i.pici = ? WHERE i.id = ?")
				.setString(0,new Integer(piciMax).toString())
				.setString(1, o.toString());
				count++;
			}
			if(count >=num){
				break;
			}
			
		}
//		return null;
	}
	
	
}

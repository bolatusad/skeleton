package com.dreamchain.skeleton.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.skeleton.dao.ImageInfoDao;
import com.dreamchain.skeleton.dao.PiciDao;
import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.Pici;
import com.dreamchain.skeleton.service.PiciService;

@Service
public class PiciServiceImpl implements PiciService {

	
	@Resource
	private PiciDao piciDao;
	
	
	@Override
	@Transactional
	public void save(Pici pici) {
		piciDao.save(pici);

	}

	@Override
	@Transactional
	public int count() {
		return piciDao.count();
	}
	
	@Override
	@Transactional
	public List<Pici> find(int start, int pagesize) {
		return piciDao.find(start, pagesize);
	}
	
	

}

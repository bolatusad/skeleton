package com.dreamchain.skeleton.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.skeleton.dao.ImageInfoDao;
import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.service.ImageInfoService;

@Service
public class ImageInfoServiceImpl implements ImageInfoService{

	@Resource
	private ImageInfoDao imageInfoDao;
	
	@Override
	@Transactional
	public ImageInfo get(Long id) {

		return imageInfoDao.get(id);
	}

	@Override
	@Transactional
	public void delete(ImageInfo imageInfo) {
		imageInfoDao.delete(imageInfo);
	}

	@Override
	@Transactional
	public List<ImageInfo> find(int start, int pagesize) {
		return imageInfoDao.find(start, pagesize);
	}

	@Override
	@Transactional
	public int count() {
		return imageInfoDao.count();
	}

	@Override
	public ImageInfo findByName(String name) {
		return imageInfoDao.findByName(name);
	}

	@Override
	public void save(ImageInfo imageInfo) {
		imageInfoDao.save(imageInfo);
	}

	@Override
	public void findImages(String start, String end,int num,int piciMax) {
		imageInfoDao.findImages(start, end,num,piciMax);
//		return images;
	}
}

package com.dreamchain.skeleton.util;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dreamchain.skeleton.dao.ImageInfoDao;
import com.dreamchain.skeleton.model.ImageInfo;
@Service
public class ImageGenerator {
	@Autowired
	ImageInfoDao imageInfoDao;
	public List<ImageInfo> generat(int id){
		List<ImageInfo> images = new ArrayList<ImageInfo>();
//		images.add(imageInfoDao.find_by_id(id-1));
//		images.add(imageInfoDao.find_by_id(id));
//		images.add(imageInfoDao.find_by_id(id+1));
		return images;
	}
}

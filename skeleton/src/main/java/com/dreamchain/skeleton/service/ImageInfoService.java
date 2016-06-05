package com.dreamchain.skeleton.service;

import java.util.List;

import com.dreamchain.skeleton.model.ImageInfo;

public interface ImageInfoService {
	public ImageInfo get(Long id);

	public void delete(ImageInfo imageInfo) ;
	
	//public void save(JgjcxxCommand jgjcxxCommand) ;
	
	//public List<ImageInfo> findByName(String name);
	
	public List<ImageInfo> find(int start, int pagesize);
	
	int count();
	
	public ImageInfo findByName(String name);
	
	public void save(ImageInfo imageInfo);
	
	public void findImages(String start,String end,int num,int piciMax);
}

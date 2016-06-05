package com.dreamchain.skeleton.dao;

import java.util.List;

import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.Jgjcxx;

public interface ImageInfoDao {
    List<ImageInfo>  query3();
    List<ImageInfo>  test3();
	void update_tag_times(Long id);
	public ImageInfo get(Long id);
	public void delete(ImageInfo imageInfo) ;
	public List<ImageInfo> find(int start, int pagesize);
	
	int count();
	
	public ImageInfo findByName(String name);
	public void save(ImageInfo imageInfo);
	
	public void findImages(String start,String end,int num,int piciMax);
}

 
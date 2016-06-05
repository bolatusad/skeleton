package com.dreamchain.skeleton.dao;

import java.util.List;

import com.dreamchain.skeleton.model.ImageTag;

public interface ImageTagDao {
	void add(ImageTag image_tag);
	
	List<ImageTag> find(int start, int pagesize);
	
	int count();
}

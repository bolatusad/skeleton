package com.dreamchain.skeleton.service;

import java.util.List;

import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.Pici;

public interface PiciService {
	
	public List<Pici> find(int start, int pagesize);
	
	int count();
	
	public void save(Pici pici);
}

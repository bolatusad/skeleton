package com.dreamchain.skeleton.dao;

import java.util.List;

import com.dreamchain.skeleton.model.ImageInfo;
import com.dreamchain.skeleton.model.Jgjcxx;
import com.dreamchain.skeleton.model.Pici;

public interface PiciDao {
    public List<Pici>  query();
   
	public void save(Pici pici);
	
	int count();
	
	public List<Pici> find(int start, int pagesize);
}

 
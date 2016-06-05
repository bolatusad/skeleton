package com.dreamchain.skeleton.dao;

import java.util.List;

import com.dreamchain.skeleton.model.Jgjcxx;

public interface JgjcxxDao {
	public Jgjcxx get(Long id);
	public void delete(Jgjcxx jgjcxx) ;
	public void save(Jgjcxx jgjcxx) ;
	public List<Jgjcxx> findByName(String name);
	public List<Jgjcxx> find(int start, int pagesize);
	int count();
}
package com.dreamchain.skeleton.service;

import java.util.List;

import com.dreamchain.skeleton.model.Jgjcxx;
import com.dreamchain.skeleton.web.JgjcxxCommand;

public interface JgjcxxService {

	public Jgjcxx get(Long id);

	public void delete(Jgjcxx jgjcxx) ;
	
	public void save(JgjcxxCommand jgjcxxCommand) ;
	
	public List<Jgjcxx> findByName(String name);
	
	public List<Jgjcxx> find(int start, int pagesize);
	
	int count();
}

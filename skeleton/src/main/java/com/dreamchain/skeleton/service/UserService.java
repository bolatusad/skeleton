package com.dreamchain.skeleton.service;

import java.util.List;
import java.util.Map;

import com.dreamchain.skeleton.model.PageBean;
import com.dreamchain.skeleton.model.User;
import com.dreamchain.skeleton.web.UserCommand;
import com.dreamchain.skeleton.web.UserGrid;

public interface UserService {
	
	User get(Long id);
	
	void save(UserCommand userCommand);
	
	void delete(User user);
	
	UserGrid findAll();
	
	void saveAll(UserGrid userGrid);

	void updateWithAll(UserGrid userGrid);
	
	User findByName(String name);
	public int count();
	
	public List<User> find(int start,int pagesize);
	User findByNameAndPassword(String name,String password);
}

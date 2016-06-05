package com.dreamchain.skeleton.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.skeleton.dao.UserDao;
import com.dreamchain.skeleton.model.PageBean;
import com.dreamchain.skeleton.model.User;
import com.dreamchain.skeleton.service.UserService;
import com.dreamchain.skeleton.web.UserCommand;
import com.dreamchain.skeleton.web.UserGrid;

@Service
public class UserServiceImpl implements UserService {
	@Resource
	private UserDao userDao;
	//@Autowired UserDao userDao;
	
	@Override
	@Transactional(readOnly = true)
	public User get(Long id) {
		return userDao.get(id);
	}

	@Override
	@Transactional
	public void delete(User user) {
		userDao.delete(user);
	}

	@Override
	@Transactional(readOnly = true)
	public UserGrid findAll() {
		return new UserGrid(userDao.findAll());
	}

	@Override
	@Transactional
	public void save(UserCommand userCommand) {
		userDao.save(userCommand.toUser());
	}

	@Override
	@Transactional
	public void saveAll(UserGrid userGrid) {
		for (User user : userGrid.getUsers())
			userDao.save(user);
	}
	
	@Override
	@Transactional(readOnly = true)
	public void updateWithAll(UserGrid userGrid) {
		UserGrid allUsers = findAll();
		allUsers.getUserMap().putAll(userGrid.getUserMap());
		userGrid.setUserMap(allUsers.getUserMap());
	}
	
	@Override
	@Transactional
	public User findByName(String name){
		return  userDao.findByName(name);
	}
	@Override
	@Transactional
	public int count() {
		return userDao.count();
	}
	@Override
	@Transactional
	public List<User> find(int start, int pagesize){
		return userDao.find(start,pagesize);
	}

	@Override
	@Transactional
	public User findByNameAndPassword(String name, String password) {
		
		return userDao.findByNameAndPassword(name, password);
	}
}

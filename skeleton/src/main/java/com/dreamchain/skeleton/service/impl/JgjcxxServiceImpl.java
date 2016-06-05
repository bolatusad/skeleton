package com.dreamchain.skeleton.service.impl;

import java.util.List;


import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dreamchain.skeleton.dao.JgjcxxDao;
import com.dreamchain.skeleton.model.Jgjcxx;
import com.dreamchain.skeleton.service.JgjcxxService;
import com.dreamchain.skeleton.web.JgjcxxCommand;



@Service
public class JgjcxxServiceImpl implements JgjcxxService {
	@Resource
	private JgjcxxDao JgjcxxDao;

	@Override
	@Transactional(readOnly = true)
	public Jgjcxx get(Long id) {

		return JgjcxxDao.get(id);
	}

	@Override
	@Transactional
	public void delete(Jgjcxx jgjcxx) {
		JgjcxxDao.delete(jgjcxx);

	}

	@Override
	@Transactional
	public void save(JgjcxxCommand jgjcxxCommand) {
		JgjcxxDao.save(jgjcxxCommand.toJgjcxx());

	}

	@Override
	@Transactional
	public List<Jgjcxx> findByName(String name) {

		return JgjcxxDao.findByName(name);
	}

	@Override
	@Transactional
	public List<Jgjcxx> find(int start, int pagesize) {

		return JgjcxxDao.find(start, pagesize);
	}

	@Override
	@Transactional
	public int count() {

		return JgjcxxDao.count();
	}

}

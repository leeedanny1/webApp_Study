package com.kakao.web.index.service;

import com.kakao.web.index.model.dao.UserDao;
import com.kakao.web.index.model.dao.UserDaoImpl;
import com.kakao.web.index.model.dto.User;

public class UserServiceImpl implements UserService{
	private UserDao userDao;
	
	public UserServiceImpl() {
		userDao = new UserDaoImpl();
	}
	
	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}
	
	
}

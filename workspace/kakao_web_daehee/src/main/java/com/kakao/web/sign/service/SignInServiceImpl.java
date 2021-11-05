package com.kakao.web.sign.service;

import com.kakao.web.index.model.dto.User;
import com.kakao.web.sign.model.dao.SignInDao;
import com.kakao.web.sign.model.dao.SignInDaoImpl;

public class SignInServiceImpl implements SignInService{
	
	private SignInDao signInDao;
	
	public SignInServiceImpl() {
		signInDao = new SignInDaoImpl();
	}
	
	@Override
	public int signIn(String login_id, String login_password) {
		return signInDao.signIn(login_id, login_password);
	}
	
	@Override
	public User getUser(String id) {
		return signInDao.getUser(id);
	}
}

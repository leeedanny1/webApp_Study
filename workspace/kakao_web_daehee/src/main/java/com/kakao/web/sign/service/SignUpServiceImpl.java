package com.kakao.web.sign.service;

import com.kakao.web.sign.model.dao.SignUpDao;
import com.kakao.web.sign.model.dao.SignUpDaoImpl;
import com.kakao.web.sign.model.dto.UserDto;

public class SignUpServiceImpl implements SignUpService {

	private SignUpDao signUpDao;
	
	public SignUpServiceImpl() {
		signUpDao = new SignUpDaoImpl();
	}
	
	@Override
	public int idCheck(String id) {
		return signUpDao.idCheck(id);
	}
	
	@Override
	public int phoneNumberCheck(String phone, String name) {
		return signUpDao.phoneNumberCheck(phone, name);
	}
	
	@Override
	public boolean signUp(UserDto userDto) {
		return signUpDao.signUp(userDto);
	}
}

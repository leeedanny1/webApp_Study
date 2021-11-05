package com.kakao.web.userInfo.service;

import com.kakao.web.userInfo.model.dao.UserInfoDao;
import com.kakao.web.userInfo.model.dao.UserInfoDaoImpl;
import com.kakao.web.userInfo.model.dto.UpdateUserDto;

public class UserInfoServiceImpl implements UserInfoService{
	private UserInfoDao userInfoDao = null;
	
	public UserInfoServiceImpl() {
		userInfoDao = new UserInfoDaoImpl();
	}
	
	@Override
	public int updateUserInfo(UpdateUserDto updateUserDto) {
		return userInfoDao.updateUserInfo(updateUserDto);
	}

	@Override
	public int phoneNumberCheck(String phone, String name) {
		int result = userInfoDao.phoneNumberCheck(phone, name);
		if(result == 0) {
			System.out.println("통신사에 등록되지 않은 번호입니다.");
		} else if(result == 2) {
			System.out.println("이미 가입된 번호입니다.");
		} else if(result == 1) {
			System.out.println("가입 가능한 번호입니다.");
		}
		return result;
	}
}

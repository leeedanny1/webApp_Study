package com.kakao.web.userInfo.model.dao;

import com.kakao.web.userInfo.model.dto.UpdateUserDto;

public interface UserInfoDao {
	public int updateUserInfo(UpdateUserDto updateUserDto);
	public int phoneNumberCheck(String phone, String name);
}

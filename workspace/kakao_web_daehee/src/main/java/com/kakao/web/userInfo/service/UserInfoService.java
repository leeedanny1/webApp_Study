package com.kakao.web.userInfo.service;

import com.kakao.web.userInfo.model.dto.UpdateUserDto;

public interface UserInfoService {
	public int updateUserInfo(UpdateUserDto updateUserDto);
	public int phoneNumberCheck(String phone, String name);
}

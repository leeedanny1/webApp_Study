package com.kakao.web.sign.model.dao;

import com.kakao.web.sign.model.dto.UserDto;

public interface SignUpDao {
	public int idCheck(String id);
	public int phoneNumberCheck(String phone, String name);
	public boolean signUp(UserDto userDto);
}

package com.spring.study.model.dao;

import com.spring.study.model.dto.UserDto;

public interface UserDao {
	public UserDto getUser(String email);
	public int login(UserDto userDto);
	public int idCheck(String user_email);
	public int signUp(UserDto userdto);
}

package com.kakao.web.sign.service;

import com.kakao.web.index.model.dto.User;

public interface SignInService {
	public int signIn(String login_id, String login_password);
	public User getUser(String id);
}

package com.kakao.web.sign.model.dao;

import com.kakao.web.index.model.dto.User;

public interface SignInDao {
	public int signIn(String login_id,String login_password);
	public User getUser(String id);
}

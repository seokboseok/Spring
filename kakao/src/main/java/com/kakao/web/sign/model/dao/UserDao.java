package com.kakao.web.sign.model.dao;

public interface UserDao  {
	public String getUserName(String id, String password);
	public int login(String id,String password);
	
}

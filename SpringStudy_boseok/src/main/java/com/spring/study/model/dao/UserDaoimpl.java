package com.spring.study.model.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.spring.study.model.dto.UserDto;

@Repository
public class UserDaoimpl implements UserDao {
	@Autowired
	private SqlSession session;
	private static final String NAME_SPACE="com.spring.study.model.dao.UserDao";
	@Override
	public UserDto getUser(String email) {
		return session.selectOne("com.spring.study.model.dao.UserDao.getUser", email);
	}
	@Override
	public int login(UserDto userdto) {
		
		return session.selectOne("com.spring.study.model.dao.UserDao.login",userdto);
	}
	@Override
	public int idCheck(String user_email) {
		return session.selectOne(NAME_SPACE + "idCheck", user_email);
	}
	@Override
	public int signUp(UserDto userdto) {
		return session.insert(NAME_SPACE+"signUp",userdto);
	}
}


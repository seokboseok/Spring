package com.kakao.web.userinfo.model.dao;

import com.kakao.web.userinfo.model.dto.MypageDto;

public interface UpdateUserDao {
	public int updateUser(MypageDto mypagedto);
	public int phoneNumberCheck(String phone, String name);
}

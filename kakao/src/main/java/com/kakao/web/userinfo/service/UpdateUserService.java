package com.kakao.web.userinfo.service;

import com.kakao.web.userinfo.model.dto.MypageDto;

public interface UpdateUserService {
	public int updateUser(MypageDto mypageDto);
	public int phoneNumberCheck(String phone, String name);
}

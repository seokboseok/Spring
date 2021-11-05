package com.kakao.web.sign.service;

import com.kakao.web.sign.model.dto.UserDto;

public interface SignUpservice {
	public int idCheck(String id);
	public int phoneNumberCheck(String phone, String name);
	public boolean signUp(UserDto userDto);
}
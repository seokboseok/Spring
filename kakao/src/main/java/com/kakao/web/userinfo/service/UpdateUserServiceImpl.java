package com.kakao.web.userinfo.service;

import com.kakao.web.userinfo.model.dao.UpdateUserDao;
import com.kakao.web.userinfo.model.dao.UpdateUserDaoImpl;
import com.kakao.web.userinfo.model.dto.MypageDto;

public class UpdateUserServiceImpl implements UpdateUserService {
	private UpdateUserDao updateuserdao=null;

	
	public UpdateUserServiceImpl() {
		updateuserdao= new UpdateUserDaoImpl();
	}
	@Override
	public int updateUser(MypageDto mypagedto) {
		return updateuserdao.updateUser(mypagedto);
	}
	@Override
	public int phoneNumberCheck(String phone, String name) {
		int result =updateuserdao.phoneNumberCheck(phone, name);
		if(result==0) {
			System.out.println("통신사에 등록되지 않은 번호");
		}else if(result==1) {
			System.out.println("이미가입된 번호");
		}else if(result==2) {
			System.out.println("가입가능한 번호");
		}
		
		return result;
	}
}

package com.kakao.web.userinfo.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kakao.web.db.DBConnectionMgr;
import com.kakao.web.userinfo.model.dto.MypageDto;

public class UpdateUserDaoImpl implements UpdateUserDao {
	private DBConnectionMgr pool;

	public UpdateUserDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}

	@Override
	public int updateUser(MypageDto mypagedto) {
		Connection con1 = null;
		PreparedStatement pstmt = null;
		int result = 0;
		String sql = null;
		try {
			con1 = pool.getConnection();
			sql = "update user_mst set user_password=? , user_phone=? WHERE user_email=?";
			pstmt = con1.prepareStatement(sql);
			pstmt.setString(1, mypagedto.getUser_password());
			pstmt.setString(2, mypagedto.getUser_phone());
			pstmt.setString(3, mypagedto.getUser_email());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con1, pstmt);
		}
		return result;

	}

	@Override
	public int phoneNumberCheck(String phone, String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int flag = 0;
		
		try {
			con = pool.getConnection();
			sql = "select count(pm.phonenumber), count(um.user_phone) from phonenumber_list_mst pm left outer join user_mst um on(um.user_phone = pm.phonenumber) where pm.phonenumber = ? and pm.phone_user_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			
			rs.next();
			flag = rs.getInt(1) + rs.getInt(2);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return flag;
	}
}

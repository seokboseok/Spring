package com.kakao.web.sign.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kakao.web.db.DBConnectionMgr;

public class UserDaoImpl implements UserDao {
	private DBConnectionMgr pool = null;

	public UserDaoImpl() {
		pool = DBConnectionMgr.getInstance();

	}

	@Override
	public String getUserName(String id, String password) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		String name = null;
		try {
			con = pool.getConnection();
			sql = "select user_id from user_info where user_id=? and user_password =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			rs.next();
			name = rs.getString(1);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		return name;
	}
	public int login(String id, String password) {
		Connection con =null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		String sql=null;
		int flag=0;
		try {
			con=pool.getConnection();
			sql="SELECT \r\n"
					+ "COUNT(um.user_id)AS '아이디수' ,\r\n"
					+ "COUNT(ud.user_password) AS '비번수'\r\n"
					+ "FROM user_info AS um\r\n"
					+ "LEFT OUTER JOIN user_info ud ON(ud.user_id=um.user_id AND ud.user_password=?)"
					+ "WHERE um.user_id=?";
			pstmt= con.prepareStatement(sql);
			pstmt.setString(1,password);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			rs.next();
			flag = rs.getInt(1)+rs.getInt(2);
		}catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			pool.freeConnection(con);
		}
		return flag;
	}
}

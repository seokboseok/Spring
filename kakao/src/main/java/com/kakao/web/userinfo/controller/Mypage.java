package com.kakao.web.userinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakao.web.index.model.dto.User;
import com.kakao.web.index.service.UserService;
import com.kakao.web.index.service.UserServiceImpl;
import com.kakao.web.userinfo.model.dto.MypageDto;
import com.kakao.web.userinfo.service.UpdateUserService;
import com.kakao.web.userinfo.service.UpdateUserServiceImpl;

@WebServlet("/mypage")
public class Mypage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateUserService updateuser=null;
	private UserService userservice=null;

	public Mypage() {
		updateuser = new UpdateUserServiceImpl();
		userservice = new UserServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User login_user = (User) session.getAttribute("login_user");

		if (login_user == null) {
			response.sendRedirect("signin");

		} else {
			request.getRequestDispatcher("WEB-INF/views/mypage.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		MypageDto mypageDto = new MypageDto();
		mypageDto.setUser_password(request.getParameter("update_password"));
		mypageDto.setUser_phone(request.getParameter("update_phone"));
		mypageDto.setUser_name(request.getParameter("user_name"));
		mypageDto.setUser_email(request.getParameter("user_email"));

		int result=updateuser.updateUser(mypageDto);
		if (result == 1) {
			HttpSession session = request.getSession();
			User login_user = userservice.getUser(mypageDto.getUser_email());
			session.setAttribute("login_user", login_user);
		}
		response.sendRedirect("mypage");
	}
}
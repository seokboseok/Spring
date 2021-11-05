package com.kakao.web.sign.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kakao.web.index.model.dto.User;
import com.kakao.web.sign.service.SignInService;
import com.kakao.web.sign.service.SignInServiceImpl;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/signin")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SignInService signInService;

	public SignIn() {
		signInService = new SignInServiceImpl();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("login_user");
		if (user == null) {
			request.getRequestDispatcher("WEB-INF/views/sign_in.jsp").forward(request, response);// 상대경로
		}else {
			response.sendRedirect("index");
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String login_id = request.getParameter("login_id");
		String login_password = request.getParameter("login_password");
		String id_check_status=request.getParameter("id_chk_status")==null?"off":"on";
		System.out.println(id_check_status);
		int flag = signInService.signIn(login_id, login_password);
	
			
			HttpSession session = request.getSession();
			User login_user=signInService.getUser(login_id);
			session.setAttribute("login_user", login_user);
			
			if (flag == 2) {
				if(id_check_status.equals("on")) {
					String id = login_user.getId();
					Cookie userId=new Cookie("userId",id);
					userId.setMaxAge(60*60*24);
					response.addCookie(userId);
				}
				response.sendRedirect("index");
		} else {
			request.setAttribute("login_id", login_id);
			request.setAttribute("login_password", login_password);
			request.setAttribute("flag", flag);
			request.getRequestDispatcher("/WEB-INF/views/sign_in.jsp").forward(request, response);
			System.out.println("로그인실패");

		}
	}

}

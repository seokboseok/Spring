package com.kakao.web.index.controler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/logout")
public class LogOut extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Cookie[] cookies = request.getCookies();
		if(cookies!=null) {
			for (Cookie c : cookies) {
				if(c.getName().equals("userId")) {
					c.setValue(null);
					c.setMaxAge(0);
					response.addCookie(c);
					
				}
			}
		}
		session.invalidate();
		response.sendRedirect("index");
	}

}

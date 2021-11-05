package com.kakao.web.sign.controler;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kakao.web.sign.model.dto.UserDto;
import com.kakao.web.sign.service.SignUpServiceImpl;
import com.kakao.web.sign.service.SignUpservice;

@WebServlet("/signUp")
public class signup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SignUpservice signUpService;
	
	public signup() {
		signUpService = new SignUpServiceImpl();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		request.getRequestDispatcher("WEB-INF/views/sign_up_email.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String submitStatus = request.getParameter("submit_status");
		
		if(submitStatus.equals("email")) {
			String id = request.getParameter("id");
			
			int flag = signUpService.idCheck(id);
			request.setAttribute("id", id);
			
			if(flag == 1) {
				request.setAttribute("flag", flag);
				
				request.getRequestDispatcher("WEB-INF/views/sign_up_email.jsp").forward(request, response);
			}else {
				request.getRequestDispatcher("WEB-INF/views/sign_up_password.jsp").forward(request, response);
			}
		}else if(submitStatus.equals("password")) {
			request.setAttribute("id",request.getParameter("id"));
			request.getRequestDispatcher("WEB-INF/views/sign_up_repassword.jsp").forward(request, response);
			
			
		}else if(submitStatus.equals("repassword")) {
			request.setAttribute("id",request.getParameter("id"));
			request.setAttribute("password",request.getParameter("password"));
			request.getRequestDispatcher("WEB-INF/views/sign_up_name.jsp").forward(request, response);
			
		}else if(submitStatus.equals("name")) {
			request.setAttribute("id",request.getParameter("id"));
			request.setAttribute("password",request.getParameter("password"));
			request.setAttribute("name",request.getParameter("name"));
			request.getRequestDispatcher("WEB-INF/views/sign_up_phone.jsp"). forward(request, response);
			
		}else if(submitStatus.equals("phone")) {
			request.setAttribute("id",request.getParameter("id"));
			request.setAttribute("password",request.getParameter("password"));
			request.setAttribute("repassword",request.getParameter("repassword"));
			request.setAttribute("name",request.getParameter("name"));
			String submitFlag = request.getParameter("submit_flag");
			
			if(submitFlag.equals("1")) {
				UserDto userdto= new UserDto();
				userdto.setUser_email(request.getParameter("id"));
				userdto.setUser_password(request.getParameter("password"));
				userdto.setUser_name(request.getParameter("name"));
				userdto.setUser_phone(request.getParameter("phone"));
				boolean signUpflag= signUpService.signUp(userdto);
				if(signUpflag==true) {
					response.sendRedirect("signIn");
				}else {
					request.getRequestDispatcher("WEB-INF/views/sign_up_phone.jsp").forward(request, response);
				}
				
				
				
			}else if(submitFlag.equals("2")) {
				String phone =request.getParameter("phone");
				String name =request.getParameter("name");
				if(request.getParameter("phone")!= null&&request.getParameter("name")!=null) {
					int flag=signUpService.phoneNumberCheck(phone,name);
					request.setAttribute("flag",flag);
					
					request.getRequestDispatcher("WEB-INF/views/sign_in.jsp").forward(request, response);
					
				}
			}
		}else {
			System.out.println("접속오류!(잘못된 접근)");
		}
	
	}

}
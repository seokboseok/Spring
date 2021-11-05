package com.kakao.web.userinfo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.kakao.web.userinfo.service.UpdateUserService;
import com.kakao.web.userinfo.service.UpdateUserServiceImpl;


@WebServlet("/phonenumbercheck")
public class PhonenumberCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UpdateUserService updateUserService=null;
	public PhonenumberCheck() {

		updateUserService = new UpdateUserServiceImpl();

	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phoneInfo = request.getParameter("phoneInfo");
		System.out.println(phoneInfo);	
		JsonParser parser= new JsonParser();
		JsonElement element=parser.parse(phoneInfo);
		JsonObject jsonObject = element.getAsJsonObject();
		String user_name= jsonObject.get("user_name").getAsString();
		String user_phone=jsonObject.get("user_phone").getAsString();
		int result = updateUserService.phoneNumberCheck(user_phone, user_name);
		
		response.setContentType("text/html;charcet=UTF-8");
		response.getWriter().print(result);
		
	}

}

package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.UserInfoModel;

@Controller
public class UserinfoController {
	@RequestMapping(value = "/user-info-insert", method = RequestMethod.GET)
	public ModelAndView UserinfoController2() {
		ModelAndView mav = new ModelAndView("userinfoinsert");
		return mav;
	}

	@RequestMapping(value = "/insertdata", method = RequestMethod.POST, produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String insertData(UserInfoModel userinfomodel) {
		return userinfomodel.getUser_id() + "," + userinfomodel.getUser_password() + ","
		+userinfomodel.getUser_phone()+ "," + userinfomodel.getUser_name();
	}
}

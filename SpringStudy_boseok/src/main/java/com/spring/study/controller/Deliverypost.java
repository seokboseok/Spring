package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Deliverypost {
	@RequestMapping(value="postmanDelivery", method = RequestMethod.POST,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String postdelivery(@RequestParam String customer_name,
			@RequestParam String customer_address,
			@RequestParam String customer_phone,
			@RequestParam String customer_etc
			) {
		return "배송자 이름 : "+customer_name+"\n배송자 주소 : "+customer_address+"\n배송자 전화번호 : "+customer_phone+"\n요청사항 : "+customer_etc;
	}
}

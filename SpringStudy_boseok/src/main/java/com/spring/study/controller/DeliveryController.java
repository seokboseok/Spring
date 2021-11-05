package com.spring.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.spring.study.model.Custommer;

@Controller
public class DeliveryController {
@RequestMapping( value="/delivery", method=RequestMethod.GET)
public ModelAndView delivery() {
	return new ModelAndView("delivery");
}
@RequestMapping( value="/delivery-request", method=RequestMethod.POST)
public ModelAndView deliveryRequest(Custommer customer) {
	System.out.println("test");
	ModelAndView mav = new ModelAndView("deliveryinfo");
	mav.addObject("customer", customer);
	return mav;
	}
}
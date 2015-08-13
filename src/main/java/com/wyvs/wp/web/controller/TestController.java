package com.wyvs.wp.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 测试controller
 */
@Controller
@RequestMapping("test")
public class TestController extends AbstractController {


    @RequestMapping( params = "action=test")
    public ModelAndView initTestPage(){
		ModelAndView mav = new ModelAndView("test/test") ;
		return mav ;

	}



}

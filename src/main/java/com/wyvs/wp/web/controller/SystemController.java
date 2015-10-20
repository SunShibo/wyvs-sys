package com.wyvs.wp.web.controller;

import com.wyvs.wp.constants.LoginConstant;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.RoleDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆Controller
 */
@Controller
@RequestMapping("system")
public class SystemController extends AbstractController {

    @RequestMapping( params = "action=prompt")
    public ModelAndView systemPrompt(HttpServletRequest request
            , HttpServletResponse response ,String title , String content){

		ModelAndView mav = new ModelAndView("system/system_prompt") ;
		mav.addObject("title" , title) ;
		mav.addObject("content" , content) ;
		return mav;
	}

}

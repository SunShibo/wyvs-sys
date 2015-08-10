package com.wyvs.wp.web.controller;

import java.util.List;

import com.wyvs.wp.constants.LoginConstant;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.web.controller.base.BaseCotroller;
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
@RequestMapping("login")
public class LoginController extends AbstractController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private RoleService roleService ;


    @RequestMapping( params = "action=login")
    public ModelAndView login(HttpServletRequest request
            , HttpServletResponse response , MemberDo member){

        //校验参数
		if (member == null || member.getEmail() == null
                || member.getPassword() == null ) {

            ModelAndView mav = new ModelAndView("login.jsp") ;
            mav.addObject("information" , "非法请求!") ;
            return mav ;
		}

		MemberDo memberInfo = memberService.login(member);
		if (memberInfo == null) { // 判断是否找到账户和密码是否正确
            ModelAndView mav = new ModelAndView("login.jsp") ;
            mav.addObject("information" , "Can't find the matched account") ;
            return mav ;
		}

		if (memberInfo.getEnabledState() == MemberDo.STATUS_DISABLED) {
			ModelAndView mav = new ModelAndView("login.jsp") ;
			mav.addObject("information" , "登陆拒绝") ;
			return mav ;
		}

		if (memberInfo.getEnabledState() == MemberDo.STATUS_NONACTIVATED) {
			ModelAndView mav = new ModelAndView("login.jsp") ;
			mav.addObject("information" , "该账号未激活，请访问注册邮箱中的激活链接!") ;
			return mav ;
		}


		// 查找菜单
		List<PermissionDo> menuList = roleService
				.gerMenuListByRoleId(memberInfo.getId());

		// 菜单列表
		super.putSession(request ,LoginConstant.USER_MENU_LIST, menuList);
		// 登陆用户信息
		super.putSession(request ,LoginConstant.LOGIN_USER_INFO, memberInfo);

		ModelAndView mav = new ModelAndView("layout/master") ;
		return mav;
	}


	@RequestMapping( params = "action=initMaster")
		 public ModelAndView initMaster(HttpServletRequest request
			, HttpServletResponse response ){

		ModelAndView mav = new ModelAndView("layout/master") ;
		return mav;
	}

	@RequestMapping( params = "action=initLogin")
	public ModelAndView initLogin(HttpServletRequest request
			, HttpServletResponse response ){

		ModelAndView mav = new ModelAndView("login") ;
		return mav;
	}


}

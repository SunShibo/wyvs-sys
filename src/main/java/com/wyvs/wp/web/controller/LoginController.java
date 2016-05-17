package com.wyvs.wp.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.wyvs.wp.constants.LoginConstant;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.RoleDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.util.MD5Util;

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
		if (memberInfo == null) { // 判断是否存在账户
            ModelAndView mav = new ModelAndView("login.jsp") ;
            mav.addObject("information" , "Can't find the matched account") ;
            return mav ;
		}

		if (!memberInfo.getPassword().equals(
				MD5Util.digest(member.getPassword()))) {

		}

		if (memberInfo.getEnabledState() == MemberDo.ENABLEDSTATE_DISABLED) {
			ModelAndView mav = new ModelAndView("login.jsp") ;
			mav.addObject("information" , "登陆拒绝") ;
			return mav ;
		}

		if (memberInfo.getEnabledState() == MemberDo.ENABLEDSTATE_NONACTIVATED) {
			ModelAndView mav = new ModelAndView("login.jsp") ;
			mav.addObject("information" , "该账号未激活，请访问注册邮箱中的激活链接!") ;
			return mav ;
		}
		//查找角色信息
		RoleDo role  = roleService.getRoleDoById(memberInfo.getRoleId());
		// 菜单列表
		super.putSession(request ,LoginConstant.LOGIN_ROLE_INFO , role);
		// 登陆用户信息
		super.putSession(request ,LoginConstant.LOGIN_USER_INFO, memberInfo);

		ModelAndView mav = new ModelAndView("redirect:/login?action=home") ;
		return mav;
	}

	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping( params = "action=logout")
	public ModelAndView logout (HttpServletRequest request
			, HttpServletResponse response ) {

		super.removeSession(request ,LoginConstant.LOGIN_USER_INFO );
		super.removeSession(request ,LoginConstant.USER_MENU_LIST );

		ModelAndView mav = new ModelAndView("WEB-INF/login.jsp") ;
		return mav;
	}

	/**
	 * home页
	 * @return
	 */
	@RequestMapping( params = "action=home")
	public ModelAndView home (HttpServletRequest request
			, HttpServletResponse response ) {

		ModelAndView mav = new ModelAndView("home/home") ;
		return mav;
	}

}

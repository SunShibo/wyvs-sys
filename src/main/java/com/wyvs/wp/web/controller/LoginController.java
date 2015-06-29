package com.wyvs.wp.web.controller;

import java.util.List;

import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.entity.RoleDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.systemConfig.Constants;
import com.wyvs.wp.util.MD5Util;
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
//public class LoginController extends BaseCotroller {
public class LoginController  {

//
	@Autowired
	private MemberService memberService;

	@Autowired
	private RoleService roleService;


    @RequestMapping( params = "action=initPage")
    public ModelAndView login(HttpServletRequest request
            , HttpServletResponse response , MemberDo member){

		ModelAndView mav = new ModelAndView("login") ;

        //校验参数
		if (member == null || member.getEmail() == null
                || member.getPassword() == null ) {

            mav.addObject("information" , "非法请求!") ;
            return mav ;
		}

		MemberDo memberInfo = memberService.login(member);
		if (memberInfo == null) { // 判断该账户是否注册

            mav.addObject("information" , "Can't find the matched account") ;
            return mav ;
		}

		String md5Password = MD5Util.digest(memberInfo.getPassword()) ;
		if (!memberInfo.getPassword().equals(md5Password)) {

			mav.addObject("information" , "密码与用户名不符！") ;
			return mav ;
		}

		if (memberInfo.getState() == MemberDo.STATUS_DISABLED) {
			mav.addObject("information" , "该账户已停用！") ;
			return mav ;
		}

		if (memberInfo.getState() == MemberDo.STATUS_NONACTIVATED) {
			mav.addObject("information" , "您的账户尚未激活，请通过验证激活该账户！") ;
			return mav ;
		}

		//存入session
		request.getSession().setAttribute(Constants.LOGIN_MEMBER , memberInfo );

		//查找角色，和权限列表
		RoleDo role = roleService.queryRoleDetailById(memberInfo.getRoleId()) ;

		request.getSession().setAttribute( , role);
//
//		// 菜单列表
//		this.sput(LoginConstant.USER_MENU_LIST, menuList);
//
//		// 登陆用户信息
//		this.sput(LoginConstant.SESSION_LOGIN_MEMBERINFO, memberInfo);// 将用户信息存入session

		return mav ;
	}
//
//	/**
//	 * 退出系统
//	 *
//	 * @return
//	 */
//	public String loginOut() {
//		this.getRequest().getSession().removeAttribute(
//				LoginConstant.SESSION_LOGIN_MEMBERINFO);// 清除登陆的用户信息
//
//		this.getRequest().getSession().removeAttribute(
//				LoginConstant.USER_MENU_LIST);// 清除登陆用户的菜单信息
//
//		return "login";
//	}
//
//	public MemberDo getMember() {
//		return member;
//	}
//
//	public void setMember(MemberDo member) {
//		this.member = member;
//	}

}

package com.wyvs.wp.web.controller;

import java.util.List;

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

//
	@Autowired
	private MemberService memberService;

	@Autowired
	private RoleService roleService;
////	@Autowired
////	private RoleInfoService roleInfoService;


    @RequestMapping( params = "action=initPage")
    public ModelAndView login(HttpServletRequest request
            , HttpServletResponse response , MemberDo member){

        //校验参数
		if (member == null || member.getEmail() == null
                || member.getPassword() == null ) {

            ModelAndView mav = new ModelAndView("login") ;
            mav.addObject("information" , "非法请求!") ;
            return mav ;
		}

		//查找登陆
		MemberDo memberInfo = memberService.login(member);
		if (memberInfo == null) { // 判断是否找到账户和密码是否正确
            ModelAndView mav = new ModelAndView("login") ;
            mav.addObject("information" , "Can't find the matched account") ;
            return mav ;
		}

		// 查找菜单
		List<PermissionDo> menuList = roleService
				.gerMenuListByRoleId(memberInfo.getId());

		return new ModelAndView("master") ;

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

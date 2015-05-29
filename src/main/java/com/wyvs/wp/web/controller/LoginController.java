package com.wyvs.wp.web.controller;

import java.util.List;

import com.wyvs.wp.web.controller.base.BaseCotroller;
import org.springframework.beans.factory.annotation.Autowired;


public class LoginController extends BaseCotroller {
//
//	/**
//	 *
//	 */
//	private static final long serialVersionUID = 1L;
//
////	@Autowired
////	private MemberService memberService;
////	@Autowired
////	private RoleInfoService roleInfoService;
////
////	private MemberInfo member;
//
//	/**
//	 * 登陆
//	 *
//	 * @return
//	 */
//	public String login() {
//
//		if (member == null) {
//			return "login";
//		}
//
//		MemberInfo memberInfo = memberService.login(member);
//		if (memberInfo == null) { // 判断是否找到账户和密码是否正确
//
//			this.cput("information", "Can't find the matched account");
//
//			return "login";
//		}
//
//		// 查找菜单
//		List<PermissionInfo> menuList = roleInfoService
//				.gerMenuListByRoleId(memberInfo);
//
//		// 菜单列表
//		this.sput(LoginConstant.USER_MENU_LIST, menuList);
//
//		// 登陆用户信息
//		this.sput(LoginConstant.SESSION_LOGIN_MEMBERINFO, memberInfo);// 将用户信息存入session
//
//		return "mainPage";
//	}
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
//	public MemberInfo getMember() {
//		return member;
//	}
//
//	public void setMember(MemberInfo member) {
//		this.member = member;
//	}

}

package com.wyvs.wp.web.controller;

import com.wyvs.wp.dao.PermissionDao;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.entity.QuitDo;
import com.wyvs.wp.entity.RoleDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.PermissionService;
import com.wyvs.wp.service.QuitService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.util.*;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * 登陆Controller
 */
@Controller
@RequestMapping("role")
public class RoleController extends AbstractController {

	@Autowired
	private RoleService roleService;

	@Autowired
	private PermissionDao permissionDao ;



	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping( params = "action=queryRoleList")
	public ModelAndView queryRoleList (HttpServletRequest request
			, HttpServletResponse response ) {
		try {
			List<RoleDo> roleList = roleService.getRoleList() ;
			List<PermissionDo> permissionList =  permissionDao.selectAllPermission () ;

			ModelAndView mav = new ModelAndView("role/role_list") ;
			mav.addObject("roleList" , roleList) ;
			mav.addObject("permissionList" , permissionList) ;
			return mav;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

}

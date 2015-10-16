package com.wyvs.wp.web.controller;

import com.wyvs.wp.dao.PermissionDao;
import com.wyvs.wp.dao.RoleDao;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.entity.RoleDo;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.util.JsonUtils;
import com.wyvs.wp.util.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登陆Controller
 */
@Controller
@RequestMapping("permission")
public class PermissionController extends AbstractController {

	@Autowired
	private PermissionDao permissionDao ;

	@Autowired
	private RoleService roleService ;

	@Autowired
	private RoleDao roleDao ;

	/**
	 * 添加权限
	 * @param request
	 * @param response
	 * @param permissionDo
	 */
	@RequestMapping( params = "action=addPermission")
	public void addPermission (HttpServletRequest request
			, HttpServletResponse response , PermissionDo permissionDo) {


		if (StringUtils.isEmpty(permissionDo.getName())
				|| permissionDo.getParentId() == null ) {
			JSONObject json = JsonUtils.encapsulationJSON(0, "", "") ;
			super.safeJsonPrint(response , json.toString());
			return ;
		}

		//查找父类记录
		PermissionDo parentPer = permissionDao.selectPermissionById(permissionDo.getParentId()) ;
		if (parentPer == null ) {
			JSONObject json = JsonUtils.encapsulationJSON(0, "", "") ;
			super.safeJsonPrint(response , json.toString());
			return ;
		}

		permissionDo.setLevel(parentPer.getLevel() +	1);
		int rowNum = permissionDao.insert(permissionDo) ;
		JSONObject json = JsonUtils.encapsulationJSON( rowNum > 0 ? 1 : 0, "", "") ;
		super.safeJsonPrint(response , json.toString());
	}

	/**
	 *
	 */
	@RequestMapping( params = "action=checkUniqueFlag")
	public void checkUniqueFlag (HttpServletRequest request
			, HttpServletResponse response , String UniqueFlag) {

	}

	/**
	 * 角色id查找权限id
	 * @param request
	 * @param response
	 * @param roleId
	 */
	@RequestMapping( params = "action=queryPermissionByRoleId")
	public void queryPermissionByRoleId (HttpServletRequest request
			, HttpServletResponse response , int roleId) {

		//查找角色对象
		RoleDo role = roleService.getById(roleId) ;
		if (role ==  null ) {
			JSONObject result = JsonUtils.encapsulationJSON(0,"","not found an Object by id.") ;
			super.safeJsonPrint(response , result.toString());
			return ;
		}

		JSONObject data = new JSONObject() ;
		data.put("permissionIds" , StringUtils.clearNull(role.getPermissionIds())) ;
		JSONObject result = JsonUtils.encapsulationJSON(1,"",data.toString()) ;
		super.safeJsonPrint(response , result.toString());
	}

	@RequestMapping( params = "action=modifyPermissionForRole")
	public void modifyPermissionForRole (HttpServletRequest request
			, HttpServletResponse response , int roleId , String permissionIds) {

		RoleDo role = new RoleDo() ;
		role.setId(roleId);
		role.setPermissionIds(permissionIds);
		int rowNum = roleDao.update(role) ;

		JSONObject result = JsonUtils.encapsulationJSON(rowNum > 0 ? 1 : 0 ,"","") ;
		super.safeJsonPrint(response , result.toString());
	}

}

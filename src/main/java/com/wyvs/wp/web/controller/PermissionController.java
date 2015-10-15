package com.wyvs.wp.web.controller;

import com.wyvs.wp.dao.PermissionDao;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.entity.RoleDo;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.util.JsonUtils;
import com.wyvs.wp.util.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登陆Controller
 */
@Controller
@RequestMapping("permission")
public class PermissionController extends AbstractController {

	@Autowired
	private PermissionDao permissionDao ;

	/**
	 * 退出登录
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping( params = "action=addPermission")
	public void addPermission (HttpServletRequest request
			, HttpServletResponse response , PermissionDo permissionDo) {

		try {
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
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}

package com.wyvs.wp.service;

import com.wyvs.wp.constants.SysConstants;
import com.wyvs.wp.dao.PermissionDao;
import com.wyvs.wp.entity.PermissionDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationObjectSupport;

import javax.servlet.ServletContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SystemService extends WebApplicationObjectSupport {

	@Autowired
	private PermissionDao permissionDao;

	/**
	 * 启动服务时的，初始化方法.
	 */
	public void startServerInit() {
		this.uploadPermissionMapToContext() ;
	}

	public Map<String , Object> uploadPermissionMapToContext () {
		WebApplicationContext context = super.getWebApplicationContext() ;
		ServletContext servletContext = context.getServletContext();
		List<PermissionDo> perList =  permissionDao.selectAllPermission() ;
		Map<String , Object> map = new HashMap<String, Object>() ;
		//存入map，便于快速查找
		for (PermissionDo per : perList) {
			map.put(per.getUrl() , true) ;
		}
		servletContext.setAttribute(SysConstants.ALL_PERMISSION, map);
		return map ;
	}

}

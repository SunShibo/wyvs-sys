package com.wyvs.wp.service;

import com.wyvs.wp.dao.PermissionDao;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PermissionService {

	public static final String PERMISSION_MENU_TYPE = "menu" ;
	public static final String PERMISSION_ALL_TYPE = "All" ;
	@Autowired
	private PermissionDao permissionDao;

	
	private static final Logger logger = Logger.getLogger(PermissionService.class);


	/**
	 * 添加记录
	 * @param permission
	 * @return
	 */
	public int insertPermission(PermissionDo permission){
		return permissionDao.insert(permission) ;
	}

	/**
	 * 通过id数组查找权限集合
	 * @param permissionIds
	 * @return
	 */
	public List<PermissionDo> queryPermissionByIds(String permissionIds ){

		//参数校验
		if ( StringUtils.isEmpty(permissionIds) ) {
			return new ArrayList<PermissionDo>() ;
		}
		//最高管理员返回所有权限信息
		if (permissionIds.equals("ALL")) {
			return permissionDao.selectAllPermission() ;
		}
		String[] ids = permissionIds.split(",") ;
		//通过id查找数据
		return permissionDao.selectPermissionByIdArray(ids) ;
	}

}

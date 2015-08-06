package com.wyvs.wp.service;

import com.wyvs.wp.dao.PermissionDao;
import com.wyvs.wp.entity.PermissionDo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class PermissionService {

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
	 * @param ids
	 * @return
	 */
	public List<PermissionDo> queryPermissionByIdArray(String[] ids){

		//参数校验
		if (ids == null || ids.length == 0) {
			return new ArrayList<PermissionDo>() ;
		}

		return permissionDao.selectPermissionByIdArray(ids) ;
	}

}

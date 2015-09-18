package com.wyvs.wp.service;

import com.wyvs.wp.dao.RoleDao;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.entity.RoleDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PermissionService permissionService;

	/**
	 * 通过id查找角色信息及关联信息
	 * @param roleId
	 * @return
	 */
	public RoleDo getRoleDoById (int roleId) {
		RoleDo role = roleDao.selectById(roleId) ;
		if ( role == null ) {
			return null ;
		}
		//查找权限集合
		List<PermissionDo> perList = permissionService.queryPermissionByIds(role.getPermissionIds() ) ;
		role.setPermissionList(perList);
		return role ;
	}

	/**
	 * 通过id查找数据
	 * @param roleId
	 * @return
	 */
	public RoleDo getById (int roleId) {
		return  roleDao.selectById(roleId) ;
	}

	public List<RoleDo> getRoleList() {
		return roleDao.selectRoleList() ;
	}



}

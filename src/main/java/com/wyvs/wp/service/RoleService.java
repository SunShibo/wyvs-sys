package com.wyvs.wp.service;

import com.wyvs.wp.dao.RoleDao;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.entity.RoleDo;
import com.wyvs.wp.util.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.management.relation.Role;
import java.util.List;


@Service
@Transactional
public class RoleService {

	@Autowired
	private RoleDao roleDao;

	@Autowired
	private PermissionService permissionService;

	
	private static final Logger logger = Logger.getLogger(RoleService.class);

	/**
	 * 添加记录
	 * @param role
	 * @return
	 */
	public int insertRole(RoleDo role) {
		return roleDao.insert(role) ;
	}

	/**
	 * 通过id查找权限集合
	 * @param roleId
	 * @return
	 */
	public RoleDo queryRoleDetailById(Integer roleId) {

		//查找角色信息
		RoleDo role = this.queryRoleById(roleId) ;

		if (role == null ) {
			return null ;
		}

		if (StringUtils.isEmpty(role.getPermissionIds())) {
			return role ;
		}

		String[] idArray = role.getPermissionIds().split(",") ;

		//查找权限集合
		List<PermissionDo> permissionList = permissionService.queryPermissionByIdArray(idArray) ;
		role.setPermissionList(permissionList);
		return role ;
	}

	/**
	 * 通过id查找角色
	 * @param roleId
	 * @return
	 */
	public RoleDo queryRoleById(Integer roleId) {

		//查找角色信息
		RoleDo role = roleDao.selectRoleById(roleId) ;
		return role  ;
	}



}

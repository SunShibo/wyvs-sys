package com.wyvs.wp.dao;

import com.wyvs.wp.entity.RoleDo;

import java.util.List;

public interface RoleDao {

    /**
     * 通过角色id查找角色信息
     * @param roleId
     * @return
     */
    public RoleDo selectById (int roleId) ;

    /**
     * 查找角色列表
     * @return
     */
    public List<RoleDo> selectRoleList () ;
 	 
}

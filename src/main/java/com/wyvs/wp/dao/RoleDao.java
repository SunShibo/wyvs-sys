package com.wyvs.wp.dao;

import com.wyvs.wp.entity.RoleDo;

public interface RoleDao {

    /**
    * 插入数据
    * @param roleDo
    * @return
    */
    public int insert(RoleDo roleDo) ;

    /**
    * 通过id查找角色信息
    * @param id
    * @return
    */
    public RoleDo selectRoleById (int id) ;

 	 
}

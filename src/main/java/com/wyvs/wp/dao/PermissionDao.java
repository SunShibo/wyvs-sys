package com.wyvs.wp.dao;

import com.wyvs.wp.entity.PermissionDo;

import java.util.List;

public interface PermissionDao {

	/**
	 * 插入数据
	 * @param permissionDo
	 * @return
	 */
     public int insert(PermissionDo permissionDo);

    /**
     * 通过id数组查找权限结合
     * @param ids
     * @return
     */
    public List<PermissionDo> selectPermissionByIdArray(String[] ids) ;
 	 
}

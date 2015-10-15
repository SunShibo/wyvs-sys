package com.wyvs.wp.dao;

import com.wyvs.wp.entity.PermissionDo;
import org.apache.ibatis.annotations.Param;

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
    public List<PermissionDo> selectPermissionByIdArray(@Param("ids")String[] ids)  ;

    /**
     * 通过id数组查找权限结合
     * @param id
     * @return
     */
    public PermissionDo selectPermissionById(@Param("id")int  id)  ;

    /**
     * 查找全部的权限信息
     * @return
     */
    public List<PermissionDo> selectAllPermission() ;
 	 
}

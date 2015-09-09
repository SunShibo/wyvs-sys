package com.wyvs.wp.dao;

import com.wyvs.wp.entity.TaskDo;

import java.util.List;
import java.util.Map;

public interface TaskDao {

     public int insert(TaskDo taskDo);

     /**
      * 获取分页列表
      * @param map
      * @return
      */
     public List<TaskDo> getListPage(Map<String , Object> map) ;

     /**
      * 获取总记录数
      * @param map
      * @return
      */
     public int getListCount(Map<String , Object> map) ;
 	 
}

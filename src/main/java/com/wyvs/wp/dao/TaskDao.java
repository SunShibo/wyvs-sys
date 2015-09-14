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

     /**
      * 通过id查找记录
      * @param taskId
      * @return
      */
     public TaskDo selectById(int taskId) ;

     /**
      * 通过id修改
      * @param taskDo
      * @return
      */
     public int updateTask(TaskDo taskDo) ;
 	 
}

package com.wyvs.wp.dao;

import com.wyvs.wp.entity.TaskUserDo;

import java.util.List;

public interface TaskUserDao {

     public int insert(TaskUserDo taskUser);

     /**
      * 查询任务实施者
      * @param taskId
      * @return
      */
     public List<TaskUserDo> selectListByTaskId (int taskId) ;

 	 
}

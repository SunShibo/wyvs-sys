package com.wyvs.wp.dao;

import com.wyvs.wp.entity.TaskUserDo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TaskUserDao {

     public int insert(TaskUserDo taskUser);

     /**
      * 查询任务实施者
      * @param taskId
      * @return
      */
     public List<TaskUserDo> selectListByTaskId (int taskId) ;

     /**
      * 批量插入数据
      * @param taskUsers
      * @return
      */
     public int insertTaskUserByArray ( @Param("taskUsers") List<TaskUserDo> taskUsers) ;

 	 
}

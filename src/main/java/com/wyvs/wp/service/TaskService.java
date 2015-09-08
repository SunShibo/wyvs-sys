package com.wyvs.wp.service;

import com.wyvs.wp.dao.TaskDao;
import com.wyvs.wp.entity.TaskDo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class TaskService {

	@Autowired
	private TaskDao taskDao;
	
	private static final Logger logger = Logger.getLogger(TaskService.class);

	/**
	 * 添加记录
	 * @param taskDo
	 * @return
	 */
	public int addTask (TaskDo taskDo) {
		return  taskDao.insert(taskDo) ;
	}

}

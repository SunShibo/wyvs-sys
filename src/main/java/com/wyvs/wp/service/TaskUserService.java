package com.wyvs.wp.service;

import com.wyvs.wp.dao.TaskUserDao;
import com.wyvs.wp.entity.TaskUserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class TaskUserService {

	@Autowired
	private TaskUserDao taskUserDao;

	/**
	 * 添加任务人员
	 * @param taskUserDo
	 * @return
	 */
	public int addUserForTask(TaskUserDo taskUserDo) {
		return taskUserDao.insert(taskUserDo) ;
	}

	/**
	 * 通过任务ID查找TU
	 * @param taskId
	 * @return
	 */
	public List<TaskUserDo> getTUListByTaskId(int taskId) {
		return taskUserDao.selectListByTaskId(taskId) ;
	}

}

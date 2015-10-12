package com.wyvs.wp.service;

import com.wyvs.wp.dao.TaskUserDao;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.TaskUserDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class TaskUserService {

	@Autowired
	private TaskUserDao taskUserDao;

	@Autowired
	private MemberService memberService;

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

	/**
	 * 批量插入数据
	 * @param memberIds
	 * @param taskId
	 * @return
	 */
	public int insertUserForTaskByMemberId (String[] memberIds , int taskId ) {

		List<MemberDo> memberList = memberService.getMemberListByIds(memberIds) ;
		List<TaskUserDo> taskList = new ArrayList<TaskUserDo>() ;
		for (MemberDo member : memberList ) {
			TaskUserDo tu = new TaskUserDo() ;
			tu.setTaskId(taskId) ;
			tu.setMemberName(member.getName());
			tu.setMemberId(member.getId());
			taskList.add(tu);
		}
		return taskUserDao.insertTaskUserByArray(taskList) ;

	}


}

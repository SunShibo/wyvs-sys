package com.wyvs.wp.service;

import com.wyvs.wp.dao.TaskDao;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.TaskDo;
import com.wyvs.wp.util.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


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

	/**
	 * 获取任务列表分页
	 * @param taskDo
	 * @param queryObject
	 * @return
	 */
	public PageObject getTaskListPage (TaskDo taskDo , QueryObject queryObject , MemberDo loginUser
			,String search_type ,String  search) {
		Map<String , Object> map = new HashMap<String, Object>() ;
		map.put("pageOffset", queryObject.getPageOffset());
		map.put("pageSize", queryObject.getPageSize());
		map.put("task" , taskDo) ;
		map.put("loginUser" , loginUser) ;
		map.put("search_type" , search_type) ;
		map.put("search" , search) ;

		List<TaskDo> list = taskDao.getListPage(map);
		int count =  taskDao.getListCount(map) ;

		PageObjectUtil<TaskDo> page = new PageObjectUtil<TaskDo>();
		return page.SavePageObject(count,list , queryObject);
	}

	/**
	 * 获取任务列表返回json格式
	 * @param taskDo
	 * @param queryObject
	 * @return
	 */
	public JSONObject getTaskListPageJSON (TaskDo taskDo , QueryObject queryObject
			, MemberDo loginUser,String search_type ,String  search) {

		PageObject page = this.getTaskListPage(taskDo, queryObject , loginUser , search_type ,  search) ;
		JSONObject data = JsonUtils.getJsonObject4JavaPOJO(page , DateUtils.DATE_PATTERN) ;
		data.put("loginUserId" ,loginUser.getId() ) ;
		JSONObject json = JsonUtils.encapsulationJSON(1 , "" ,data.toString()) ;
		return json ;
	}

	public TaskDo getTaskById(int taskId) {
		return taskDao.selectById(taskId) ;
	}

	/**
	 * 通过id修改记录
	 * @param taskDo
	 * @return
	 */
	public int updateByObj (TaskDo taskDo) {
		return taskDao.updateTask(taskDo) ;
	}

	/**
	 * 按任务列表页菜单来计算每项的总数
	 * @param loginUser
	 * @return
	 */
	public JSONObject getCountByTaskMenu (MemberDo loginUser) {
		//查找所有任务
		Map<String , Object> searchAllTask = new HashMap<String, Object>() ;
		searchAllTask.put("loginUser" , loginUser) ;
		searchAllTask.put("search_type" , "ALl") ;
		int allCount =  taskDao.getListCount(searchAllTask) ;

		//查找待我解决的任务
		Map<String , Object> searchWorkingTask = new HashMap<String, Object>() ;
		searchWorkingTask.put("loginUser" , loginUser) ;
		searchWorkingTask.put("search_type" , "MY_WORKING_TASK") ;
		int workingTaskCount =  taskDao.getListCount(searchWorkingTask) ;

		//查找我完成的任务
		Map<String , Object> searchMyFinishTask = new HashMap<String, Object>() ;
		searchMyFinishTask.put("loginUser" , loginUser) ;
		searchMyFinishTask.put("search_type" , "MY_FINISH_TASK") ;
		int myFinishTaskCount =  taskDao.getListCount(searchMyFinishTask) ;

		//查找需要我验收的任务
		Map<String , Object> searchNeedCheckTask = new HashMap<String, Object>() ;
		searchNeedCheckTask.put("loginUser" , loginUser) ;
		searchNeedCheckTask.put("search_type" , "NEED_CHECK_TASK") ;
		int needCheckTaskCount =  taskDao.getListCount(searchNeedCheckTask) ;
		JSONObject json = new JSONObject() ;
		json.put( "allCount" , allCount) ;
		json.put( "workingTaskCount" , workingTaskCount) ;
		json.put( "myFinishTaskCount" , myFinishTaskCount) ;
		json.put( "needCheckTaskCount" , needCheckTaskCount) ;
		return json ;
	}

}

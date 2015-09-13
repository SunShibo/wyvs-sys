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
		JSONObject json = JsonUtils.encapsulationJSON(1 , "" ,data.toString()) ;
		return json ;
	}

}

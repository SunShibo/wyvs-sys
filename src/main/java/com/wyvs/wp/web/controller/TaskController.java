package com.wyvs.wp.web.controller;

import com.wyvs.wp.dao.TaskDao;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.TaskDo;
import com.wyvs.wp.entity.TaskUserDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.service.TaskService;
import com.wyvs.wp.service.TaskUserService;
import com.wyvs.wp.util.DateUtils;
import com.wyvs.wp.util.JsonUtils;
import com.wyvs.wp.util.QueryObject;
import com.wyvs.wp.util.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Member;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登陆Controller
 */
@Controller
@RequestMapping("task")
public class TaskController extends AbstractController {

	@Autowired
	private MemberService memberService;

	@Autowired
	private TaskService taskService ;

	@Autowired
	private TaskUserService taskUserService ;

	@Autowired
	private TaskDao taskDao ;


	/**
	 * 初始化任务页
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping( params = "action=task_index")
    public ModelAndView taskIndex(HttpServletRequest request
            , HttpServletResponse response ){

		MemberDo loginUser = super.getLoginUser(request) ;

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


		ModelAndView mav = new ModelAndView("task/task_index") ;
		mav.addObject("allCount" ,allCount) ;
		mav.addObject("workingTaskCount" ,workingTaskCount) ;
		mav.addObject("myFinishTaskCount" ,myFinishTaskCount) ;
		mav.addObject("needCheckTaskCount" ,needCheckTaskCount) ;
		return mav;
	}

	/**
	 * 添加任务
	 * @param request
	 * @param response
	 * @param taskDo
	 */
	@RequestMapping( params = "action=addTask")
	public void addTask(HttpServletRequest request
			, HttpServletResponse response , TaskDo taskDo ){

		//获取登录用户
		MemberDo loginUser = super.getLoginUser(request) ;

		String beginDate = (String)request.getAttribute("begin_time") ;
		String endDate = (String)request.getAttribute("end_time") ;

		if ( StringUtils.isEmpty(taskDo.getContent()) || StringUtils.isEmpty(taskDo.getLevel()) ) {

			JSONObject json = JsonUtils.encapsulationJSON(0 , "" , "") ;
			super.safeJsonPrint(response , json.toString());
			return ;
		}

		//任务的开始时间
		if (!StringUtils.isEmpty(beginDate) && DateUtils.isValidDate(beginDate ,  DateUtils.DATE_PATTERN)) {
			taskDo.setBeginTime(DateUtils.parseDate(beginDate , DateUtils.DATE_PATTERN ));
		}

		//任务的结束时间
		if (!StringUtils.isEmpty(endDate) && DateUtils.isValidDate(endDate ,  DateUtils.DATE_PATTERN)) {
			taskDo.setBeginTime(DateUtils.parseDate(endDate , DateUtils.DATE_PATTERN ));
		}

		taskDo.setStatus(TaskDo.STATUS_NEW);
		taskDo.setCreateUser(loginUser.getId() );
		//插入数据
		int rownum = taskService.addTask(taskDo) ;
		JSONObject json = JsonUtils.encapsulationJSON(rownum > 0 ? 1 : 0 , "" ,"") ;
		super.safeJsonPrint(response , json.toString());
	}

	/**
	 * 获取任务列表
	 * @param request
	 * @param response
	 */
	@RequestMapping( params = "action=queryTaskList")
	public void queryTaskList(HttpServletRequest request
			, HttpServletResponse response ,TaskDo taskDo
			, @RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
			, @RequestParam(value = "pageSize", defaultValue = "30") Integer pageSize
			, @RequestParam(value = "search_type", defaultValue = "All") String search_type
			,String search){

		//获取分页
		QueryObject query = new QueryObject() ;
		query.setPageNum(pageNum);
		query.setPageSize(pageSize);

		MemberDo loginUser = super.getLoginUser(request) ;
		JSONObject json = taskService.getTaskListPageJSON(taskDo, query , loginUser , search_type ,  search) ;
		super.safeJsonPrint(response , json.toString());
	}

	/**
	 * 人员加入任务
	 * @param request
	 * @param response
	 * @param taskId
	 */
	@RequestMapping( params = "action=joinTask")
	public void joinTask(HttpServletRequest request
			, HttpServletResponse response 	,int taskId){

		MemberDo loginUser = super.getLoginUser(request) ;
		TaskUserDo taskUserDo = new TaskUserDo() ;
		taskUserDo.setMemberId(loginUser.getId());
		taskUserDo.setMemberName(loginUser.getName());
		taskUserDo.setTaskId(taskId);
		try {
			int rownum = taskUserService.addUserForTask(taskUserDo) ;

			JSONObject json = JsonUtils.encapsulationJSON(rownum > 0 ? 1 : 0 , "" ,"") ;
			super.safeJsonPrint(response , json.toString());
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 通过id查找任务
	 * @param request
	 * @param response
	 * @param taskId
	 */
	@RequestMapping( params = "action=queryTaskById")
	public void queryTaskById(HttpServletRequest request
			, HttpServletResponse response 	,int taskId){

		TaskDo taskDo = taskService.getTaskById(taskId) ;//查找任务信息
		List<TaskUserDo> tuList = taskUserService.getTUListByTaskId(taskId) ;//查找任务关联的人员信息
		taskDo.setTaskUsers(tuList);

		JSONObject json = JsonUtils.getJsonObject4JavaPOJO(taskDo, DateUtils.DATE_PATTERN);
		json.put("loginUserId" ,super.getLoginUser(request).getId()) ;
		JSONObject result = JsonUtils.encapsulationJSON(
				1 , "" ,json.toString()
		) ;
		super.safeJsonPrint(response , result.toString());
	}

	/**
	 * 修改任务状态
	 * @param request
	 * @param response
	 * @param taskId
	 * @param status
	 */
	@RequestMapping( params = "action=updateStatus")
	public void updateStatus(HttpServletRequest request
			, HttpServletResponse response 	,int taskId , String status){

		if (!TaskDo.STATUS_VALUE.contains(status)) {
			JSONObject result = JsonUtils.encapsulationJSON(0 , "" ,""	) ;
			super.safeJsonPrint(response , result.toString());
			return ;
		}
		TaskDo taskDo = taskService.getTaskById(taskId) ;//查找任务信息
		if (taskDo == null ) {
			JSONObject result = JsonUtils.encapsulationJSON(0 , "" ,""	) ;
			super.safeJsonPrint(response , result.toString());
			return ;
		}
		if (status.equals(TaskDo.STATUS_CLOSE) && !taskDo.getStatus().equals(TaskDo.STATUS_FINISH)) {
			JSONObject result = JsonUtils.encapsulationJSON(0 , "" ,""	) ;
			super.safeJsonPrint(response , result.toString());
			return ;
		} else if (status.equals(TaskDo.STATUS_FINISH) && !taskDo.getStatus().equals(TaskDo.STATUS_CLOSE)) {
			JSONObject result = JsonUtils.encapsulationJSON(0 , "" ,""	) ;
			super.safeJsonPrint(response , result.toString());
			return ;
		}

		TaskDo task = new TaskDo() ;
		task.setId(taskId);
		task.setStatus(status);
		int rownum = taskService.updateByObj(task) ;
		JSONObject result = JsonUtils.encapsulationJSON(rownum > 0 ? 1 : 0 , "" ,""	) ;
		super.safeJsonPrint(response , result.toString());
	}


}

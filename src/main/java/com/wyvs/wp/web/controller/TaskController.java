package com.wyvs.wp.web.controller;

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


	/**
	 * 初始化任务页
	 * @param request
	 * @param response
	 * @return
	 */
    @RequestMapping( params = "action=task_index")
    public ModelAndView taskIndex(HttpServletRequest request
            , HttpServletResponse response ){

		ModelAndView mav = new ModelAndView("task/task_index") ;
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
			, @RequestParam(value = "pageSize", defaultValue = "30") Integer pageSize ){

		//获取分页
		QueryObject query = new QueryObject() ;
		query.setPageNum(pageNum);
		query.setPageSize(pageSize);

		JSONObject json = taskService.getTaskListPageJSON(taskDo, query) ;
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

}

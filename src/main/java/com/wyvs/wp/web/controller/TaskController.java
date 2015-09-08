package com.wyvs.wp.web.controller;

import com.wyvs.wp.entity.TaskDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.service.TaskService;
import com.wyvs.wp.util.JsonUtils;
import com.wyvs.wp.util.StringUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

	//添加任务
	@RequestMapping( params = "action=addTask")
	public void addTask(HttpServletRequest request
			, HttpServletResponse response , TaskDo taskDo ){

		if ( StringUtils.isEmpty(taskDo.getContent()) || StringUtils.isEmpty(taskDo.getLevel()) ) {

			JSONObject json = JsonUtils.encapsulationJSON(0 , "" , "") ;
			super.safeJsonPrint(response , json.toString());
			return ;
		}
		//插入数据
		int rownum = taskService.addTask(taskDo) ;
		JSONObject json = JsonUtils.encapsulationJSON(rownum > 0 ? 1 : 0 , "" ,"") ;
		super.safeJsonPrint(response , json.toString());
	}


}

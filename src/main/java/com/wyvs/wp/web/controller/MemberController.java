package com.wyvs.wp.web.controller;

import com.wyvs.wp.constants.LoginConstant;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.util.JsonUtils;
import com.wyvs.wp.util.PageObject;
import com.wyvs.wp.util.QueryObject;
import com.wyvs.wp.util.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 登陆Controller
 */
@Controller
@RequestMapping("member")
public class MemberController extends AbstractController {

	@Autowired
	private MemberService memberService;


	/**
	 * 获取会员列表
	 * @param request
	 * @param response
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
    @RequestMapping( params = "action=memberList")
    public ModelAndView memberList(HttpServletRequest request
            , HttpServletResponse response
			,@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum
			,@RequestParam(value = "pageSize", defaultValue = "30") Integer pageSize ){

		//获取分页
		QueryObject query = new QueryObject() ;
		query.setPageNum(pageNum);
		query.setPageSize(pageSize);
		PageObject<MemberDo> page = memberService.getMemberList(query) ;

		ModelAndView mav = new ModelAndView("member/member_list") ;
		mav.addObject("page" , page) ;
		return mav ;

	}

	/**
	 * 查找会员
	 * @param request
	 * @param response
	 * @param search
	 */
	@RequestMapping( params = "action=findMember")
	public void findMember(HttpServletRequest request
			, HttpServletResponse response , String search ){

		if (StringUtils.isEmpty(search)) {
			JSONObject json = JsonUtils.encapsulationJSON(0 , "参数异常！" ,  "") ;
			super.safeJsonPrint(response , json.toString());
			return ;
		}

		List<MemberDo> list = memberService.findMember(search) ;
		JSONArray ja = new JSONArray() ;
		for (MemberDo m :  list) {
			JSONObject json = new JSONObject() ;
			json.put("englishName" , StringUtils.clearNull(m.getEnglishName())) ;
			json.put("employeeId" , StringUtils.clearNull(m.getEmployeeId())) ;
			json.put("name" , StringUtils.clearNull(m.getName())) ;
			json.put("email" , StringUtils.clearNull(m.getEmail())) ;
			json.put("title" , StringUtils.clearNull(m.getTitle())) ;
			json.put("department" , StringUtils.clearNull(m.getDepartment())) ;
			ja.add(json) ;
		}
		JSONObject data = new JSONObject() ;
		data.put("memberList" , ja) ;
		JSONObject result = JsonUtils.encapsulationJSON(1 , "" ,data.toString() ) ;
		super.safeJsonPrint(response , result.toString()) ;

	}

	/**
	 * 员工状态为正式员工时，会员不可以被删除
	 * @param request
	 * @param response
	 * @param search
	 */
	@RequestMapping( params = "action=deleteMember")
	public void deleteMember(HttpServletRequest request
			, HttpServletResponse response , String search ){

		JSONObject result = JsonUtils.encapsulationJSON(1 , "" ,"" ) ;
		super.safeJsonPrint(response , result.toString()) ;

	}

	@RequestMapping( params = "action=newMemberPage")
	public ModelAndView newMemberPage(HttpServletRequest request
			, HttpServletResponse response){
		ModelAndView mav = new ModelAndView("member/new") ;
		return mav ;

	}


	@RequestMapping(method = RequestMethod.POST, params = "action=newMember")
	public void newMember(HttpServletRequest request
			, HttpServletResponse response  , MemberDo  member){

		JSONObject json = JsonUtils.encapsulationJSON(1 , "" , "") ;
		super.safeJsonPrint(response , json.toString());

	}

}

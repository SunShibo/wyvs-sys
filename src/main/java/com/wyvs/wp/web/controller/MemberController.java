package com.wyvs.wp.web.controller;

import com.wyvs.wp.constants.LoginConstant;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.service.MemberService;
import com.wyvs.wp.service.RoleService;
import com.wyvs.wp.util.JsonUtils;
import com.wyvs.wp.util.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@Autowired
	private RoleService roleService ;


    @RequestMapping( params = "action=memberList")
    public ModelAndView memberList(HttpServletRequest request
            , HttpServletResponse response , MemberDo member ){

		ModelAndView mav = new ModelAndView("login.jsp") ;
		mav.addObject("information" , "该账号未激活，请访问注册邮箱中的激活链接!") ;
		return mav ;

	}

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

}

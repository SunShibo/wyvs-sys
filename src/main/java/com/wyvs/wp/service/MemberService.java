package com.wyvs.wp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wyvs.wp.dao.MemberInfoDao;
import com.wyvs.wp.entity.MemberInfo;
import com.wyvs.wp.util.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class MemberService {

	@Autowired
	private MemberInfoDao memberInfoDao;
//	@Autowired
//	private SendEMailService sendEmailService;
	
	private static final Logger logger = Logger.getLogger(MemberService.class);

	/**
	 * 添加会员
	 * 
	 * @param memberInfo

	public void addMemberInfoByObj(MemberInfo memberInfo) {
		
		if(memberInfo == null || StringUtils.isEmpty(memberInfo.getEmail())) {
			logger.error("error>>>>>>>>>>>>>>>>>>>>>注册会员时参数异常");
			return ;
		}
		
		//查看该邮箱是否被注册
		MemberInfo result = memberInfoDao.selectMemberByEmail(memberInfo) ;
		if(result != null){
			logger.error("error>>>>>>>>>>>>>>>>>>>>>注册新会员时发现相同邮箱");
			return ;
		}
		
//		memberInfo.setPassword(MD5Util.digest(memberInfo.getPassword()));// 将密码进行MD5加密
		memberInfo.setDelFlag(0);// 0代表正常 ， 1代表已删除的会员
		memberInfo.setCreateTime(new Date());
		memberInfoDao.insert(memberInfo);
		sendEmailService.signInMemberSendMailToMember(memberInfo) ;
	}*/

	/**
	 * 
	 * @author sun
	 * @version 2014-8-28 上午11:26:27
	 * @param memberInfo
	 * @return
	 */
	public String addMemberInfoByObj2Public(MemberInfo memberInfo) {

		memberInfo.setCreateTime(new Date());
		memberInfo.setDelFlag(0);// 0代表正常 ， 1代表已删除的会员
		memberInfo.setStateId(1);
		memberInfoDao.insert(memberInfo);// 插入数据
		return "";
	}

	public PageObject<MemberInfo> getMemberInfoList(QueryInfo queryInfo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pageOffset", queryInfo.getPageOffset());
		map.put("pageSize", queryInfo.getPageSize());
		PageObjectUtil<MemberInfo> page = new PageObjectUtil<MemberInfo>();
		return page.SavePageObject(memberInfoDao.selectAllMemberCount(map),
				memberInfoDao.selectAllMemberByParam(map), queryInfo);
	}

	public MemberInfo getMemberInfoById(MemberInfo member) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entity", member);
		return memberInfoDao.selectMemberInfoById(map);
	}

	/**
	 * 通过部门节点模糊查找节点一下的用户
	 *
	 * @return
	 */
	public List<MemberInfo> getMemberInfoInfoListByLikeFlagId(
			String departmentFlag) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("departmentFlag", departmentFlag);
		return memberInfoDao.selectMemberInfoBydepartmentFlag(map);

	}

	/**
	 * 修改会员照片
	 * 
	 * @param member
	 */
	public void modifyMemberPhoto(MemberInfo member) {
		memberInfoDao.updateMemberPhoto(member);
	}

	/**
	 * 修改会员信息
	 * 
	 * @param member
	 */
	public void modifyMemberInfoByObj(MemberInfo member) {
		memberInfoDao.updateMemberInfoByObj(member);
	}

	/**
	 * 登陆方法
	 * 
	 * @param memberInfo
	 * @return
	 */
	public MemberInfo login(MemberInfo memberInfo) {
		memberInfo.setPassword(MD5Util.digest(memberInfo.getPassword()));// 将密码进行MD5加密
		return memberInfoDao.login(memberInfo);
	}

	/**
	 * 修改用户密码
	 * 
	 * @author sun
	 * @version 2015-1-8 下午02:40:34
	 * @param loginMember
	 * @param oldPwd
	 * @param newPwd
	 */
	public JSONObject resetPwdSer(MemberInfo loginMember, String oldPwd,
			String newPwd) {

		//判断参数是否为空
		if (loginMember == null || StringUtils.isEmpty(oldPwd)
				|| StringUtils.isEmpty(newPwd)) {

			return JsonUtils.encapsulationJSON(0, "参数异常", "");
		}
		
		// 对旧密码进行MD5加密
		String oldPwdMd5 = MD5Util.digest(oldPwd);
		
		// 判断与原密码是否相符
		if (!oldPwdMd5.equals(loginMember.getPassword())) {

			return JsonUtils.encapsulationJSON(0, "原密码不正确", "");
		}

		loginMember.setPassword(MD5Util.digest(newPwd)) ;
		
		//修改密码
		int rowNum = memberInfoDao.updateMemberPassword(loginMember);

		if(rowNum > 0){
			
			return JsonUtils.encapsulationJSON(1, "修改成功", "");
		}else{
			
			return JsonUtils.encapsulationJSON(0, "未知问题", "");
		}
	}

	/**
	 * 验证邮箱是否存在
	 * @author sun
	 * @version 2015-1-12 下午04:33:45
	 * @param email
	 */
	public JSONObject checkMemberemailIsExist(String email) {
		
		
		MemberInfo memberInfo = new MemberInfo() ;
		memberInfo.setEmail(email) ;
		
		//通过邮箱查找会员信息
		MemberInfo findMember = memberInfoDao.selectMemberByEmail(memberInfo) ;
		
		//返回的json对象
		JSONObject json = new JSONObject() ;
		
		if(findMember == null){ //对象为空说明该邮箱未被注册
			
			json.put("status", "y");
			json.put("info", "");
		}else{
			json.put("status", "n");
			json.put("info", "邮箱已存在");
		}
		
		return json ;
	}

}

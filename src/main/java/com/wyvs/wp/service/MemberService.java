package com.wyvs.wp.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.wyvs.wp.dao.MemberInfoDao;
import com.wyvs.wp.entity.MemberDo;
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
	 * 
	 * @author sun
	 * @version 2014-8-28 上午11:26:27
	 * @param memberInfo
	 * @return
	 */
	public String addMemberInfoByObj2Public(MemberDo memberInfo) {

		memberInfo.setCreateTime(new Date());
		memberInfo.setDelFlag(0);// 0代表正常 ， 1代表已删除的会员
		memberInfo.setState(1);
		memberInfoDao.insert(memberInfo);// 插入数据
		return "";
	}

	public PageObject<MemberDo> getMemberList(QueryObject queryInfo) {
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("pageOffset", queryInfo.getPageOffset());
		map.put("pageSize", queryInfo.getPageSize());
		PageObjectUtil<MemberDo> page = new PageObjectUtil<MemberDo>();
		return page.SavePageObject(memberInfoDao.selectMemberCount(map),
				memberInfoDao.selectMemberList(map), queryInfo);
	}

	public MemberDo getMemberInfoById(MemberDo member) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("entity", member);
		return memberInfoDao.selectMemberById(map);
	}

	/**
	 * 修改会员照片
	 * 
	 * @param member
	 */
	public void modifyMemberPhoto(MemberDo member) {
		memberInfoDao.updateMemberPhoto(member);
	}

	/**
	 * 修改会员信息
	 * 
	 * @param member
	 */
	public void modifyMember(MemberDo member) {
		memberInfoDao.updateMember(member);
	}

	/**
	 * 登陆方法
	 * 
	 * @param memberInfo
	 * @return
	 */
	public MemberDo login(MemberDo memberInfo) {
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
	public JSONObject resetPwd(MemberDo loginMember, String oldPwd,
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
		int rowNum = memberInfoDao.updatePassword(loginMember);

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
	public JSONObject checkEmailIsExist(String email) {
		
		
		MemberDo memberInfo = new MemberDo() ;
		memberInfo.setEmail(email) ;
		
		//通过邮箱查找会员信息
		MemberDo findMember = memberInfoDao.selectMemberByEmail(memberInfo) ;
		
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

	/**
	 * 查找会员
	 * @param search
	 * @return
	 */
	public List<MemberDo> findMember(String search){
		return memberInfoDao.selectMemberBySearch(search) ;
	}

}

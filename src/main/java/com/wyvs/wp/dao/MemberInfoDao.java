package com.wyvs.wp.dao;
import com.wyvs.wp.entity.MemberDo;

import java.util.List;
import java.util.Map;

public interface MemberInfoDao {
     public int insert(MemberDo MemberInfo);
     
     /**
      * 修改会员信息
      * @param memberInfo
      * @return
      */
 	 public int updateMember(MemberDo memberInfo);
 	 
 	 /**
 	  * 查找会员列表
 	  * @param map
 	  * @return
 	  */
 	 public List<MemberDo> selectMemberList(Map<String, Object> map);
 	 
 	 /**
 	  * 查找会员总记录数
 	  * @param map
 	  * @return
 	  */
 	 public int selectMemberCount(Map<String, Object> map);
 	 
 	 /**
 	  * 通过id查找会员信息
 	  * @param map
 	  * @return
 	  */
 	 public MemberDo selectMemberById(Map<String, Object> map);
 	 
 	 /**
 	  * 修改头像路径
 	  * @param memberInfo
 	  */
 	 public void updateMemberPhoto(MemberDo memberInfo);
 	 
 	 /**
 	  * 登陆
 	  * @param memberInfo
 	  * @return
 	  */
 	 public MemberDo login(MemberDo memberInfo);

 	 
 	 /**
 	  * 用该用户密码
 	  * @author sun
 	  * @version 2015-1-8 下午03:10:05
 	  * @param memberInfo
 	  * @return
 	  */
 	 public int updatePassword(MemberDo memberInfo) ;
 	 
 	 /**
 	  * 通过email查找邮箱是否注册
 	  * @author sun
 	  * @version 2015-1-12 下午04:37:10
 	  * @param memberInfo
 	  * @return
 	  */
 	 public MemberDo selectMemberByEmail(MemberDo memberInfo) ;


	/**
	 * 通过搜索条件查找会员列表
	 * @param search
	 * @return
	 */
	 public List<MemberDo> selectMemberBySearch(String search) ;
 	 
}

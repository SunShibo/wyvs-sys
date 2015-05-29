package com.wyvs.wp.dao;
import com.wyvs.wp.entity.MemberInfo;

import java.util.List;
import java.util.Map;

public interface MemberInfoDao {
     public int insert(MemberInfo MemberInfo);
     
     /**
      * 修改会员信息
      * @param memberInfo
      * @return
      */
 	 public int updateMemberInfoByObj(MemberInfo memberInfo);
 	 
 	 /**
 	  * 根据条件查找会员列表
 	  * @param map
 	  * @return
 	  */
 	 public List<MemberInfo> selectAllMemberByParam(Map<String, Object> map);
 	 
 	 /**
 	  * 查找会员总记录数
 	  * @param map
 	  * @return
 	  */
 	 public int selectAllMemberCount(Map<String, Object> map);
 	 
 	 /**
 	  * 通过id查找会员信息
 	  * @param map
 	  * @return
 	  */
 	 public MemberInfo selectMemberInfoById(Map<String, Object> map);
 	 
 	 /**
 	  * 修改头像路径
 	  * @param memberInfo
 	  */
 	 public void updateMemberPhoto(MemberInfo memberInfo);
 	 
 	 /**
 	  * 登陆
 	  * @param memberInfo
 	  * @return
 	  */
 	 public MemberInfo login(MemberInfo memberInfo);
 	 
 	 /**
 	  * 通过部门节点模糊查找会员信息集合
 	  * @param map
 	  * @return
 	  */
 	 public List<MemberInfo> selectMemberInfoBydepartmentFlag(Map<String, Object> map);
 	 
 	 /**
 	  * 用该用户密码
 	  * @author sun
 	  * @version 2015-1-8 下午03:10:05
 	  * @param memberInfo
 	  * @return
 	  */
 	 public int updateMemberPassword(MemberInfo memberInfo) ;
 	 
 	 /**
 	  * 通过email查找邮箱是否注册
 	  * @author sun
 	  * @version 2015-1-12 下午04:37:10
 	  * @param memberInfo
 	  * @return
 	  */
 	 public MemberInfo selectMemberByEmail(MemberInfo memberInfo) ;
 	 
}

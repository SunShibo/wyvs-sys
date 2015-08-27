package com.wyvs.wp.dao;

import com.wyvs.wp.entity.QuitDo;

import java.util.List;

public interface QuitDao {

     public int insert(QuitDo QuitDo);

     /**
      * 通过工作人员id查找离职记录
      * @param memberId
      * @return
      */
     public List<QuitDo> selectQuitByMemberId (int memberId) ;
     

 	 
}

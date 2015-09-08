package com.wyvs.wp.service;

import com.wyvs.wp.dao.MemberInfoDao;
import com.wyvs.wp.dao.QuitDao;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.QuitDo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@Service
@Transactional
public class QuitService {

	@Autowired
	private QuitDao quitDao;

	@Autowired
	private MemberInfoDao memberInfoDao;

	private static final Logger logger = Logger.getLogger(QuitService.class);


	public int addQuit(QuitDo quitDo) {
		return quitDao.insert(quitDo) ;
	}

	/**
	 * 通过工作人员id来查找离职记录
	 * @param memberId
	 * @return
	 */
	public List<QuitDo> getQuitByMemberId (int memberId) {
		return quitDao.selectQuitByMemberId(memberId) ;
	}

	/**
	 * 离职审批结束
	 * @param quitItemId
	 * @return
	 */
	public int quitFinish(int quitItemId) {
		//获取对象
		QuitDo quit = quitDao.getItemById(quitItemId) ;
		if (quit == null ) return 0 ;
		quit.setStatus(QuitDo.STATUS_PASS);

		//修改值
		quitDao.updateById(quit) ;

		//获取会员信息
		MemberDo memberDo  = memberInfoDao.getItemById(quit.getMemberId()) ;

		//修改会员信息
		memberDo.setState(MemberDo.STATE_QUIT);
		memberDo.setEnabledState(MemberDo.ENABLEDSTATE_DISABLED);
		return memberInfoDao.updateMember(memberDo) ;
	}

}

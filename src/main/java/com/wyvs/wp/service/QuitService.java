package com.wyvs.wp.service;

import com.wyvs.wp.dao.QuitDao;
import com.wyvs.wp.entity.QuitDo;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class QuitService {

	@Autowired
	private QuitDao quitDao;
	private static final Logger logger = Logger.getLogger(QuitService.class);


	public int addQuit(QuitDo quitDo) {
		return quitDao.insert(quitDo) ;
	}

}

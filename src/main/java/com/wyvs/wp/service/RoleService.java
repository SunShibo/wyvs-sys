package com.wyvs.wp.service;

import com.wyvs.wp.dao.MemberInfoDao;
import com.wyvs.wp.entity.PermissionDo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class RoleService {

	@Autowired
	private MemberInfoDao memberInfoDao;

	public List<PermissionDo> gerMenuListByRoleId(int id ) {
		return new ArrayList<PermissionDo>() ;
	}

}

package com.wyvs.wp.service;

import com.wyvs.wp.dao.MemberInfoDao;
import com.wyvs.wp.entity.MemberDo;
import com.wyvs.wp.entity.PermissionDo;
import com.wyvs.wp.util.*;
import net.sf.json.JSONObject;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class RoleService {

	@Autowired
	private MemberInfoDao memberInfoDao;

	public List<PermissionDo> gerMenuListByRoleId(int id ) {
		return new ArrayList<PermissionDo>() ;
	}

}

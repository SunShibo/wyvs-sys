package com.wyvs.wp.service;


import com.wyvs.wp.dao.TestDAO;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service("testService")
@Transactional
public class TestServiceImpl {

    @Resource
    private TestDAO testDAO;

    public int getCount(){
        return testDAO.getCount() ;
    }

}

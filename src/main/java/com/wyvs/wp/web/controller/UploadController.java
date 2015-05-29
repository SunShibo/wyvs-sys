package com.wyvs.wp.web.controller;

import com.wyvs.wp.service.TestServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@Controller
@RequestMapping("upload")
public class UploadController {

    @Autowired
    private TestServiceImpl testServiceImpl;

    @RequestMapping( params = "action=initPage")

    public ModelAndView initPage(HttpServletRequest request
            , HttpServletResponse response){

        try {
            int value = testServiceImpl.getCount() ;
            System.out.println(value);
        }catch (Exception e) {
            e.printStackTrace();
        }


        return new ModelAndView("test/test");
    }

}

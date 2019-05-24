package com.bw.controller;

import com.bw.common.ApplicationContextHelper;
import com.bw.common.JsonData;
import com.bw.dao.SysAclModuleMapper;
import com.bw.exception.PermissionException;
import com.bw.model.SysAclModule;
import com.bw.param.TestVo;
import com.bw.util.BeanValidator;
import com.bw.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * @auther bai
 * @data 2019/5/22 - 11:03
 * @description
 */
@Controller
@Slf4j
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello.json")
    @ResponseBody
    public JsonData hello(){
        log.info("hello");
        throw new PermissionException("test exception");
        //return JsonData.success("hello permission");
    }

    @RequestMapping("/index")
    public ModelAndView index(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping("/validate.json")
    @ResponseBody
    public JsonData validate(TestVo vo){
        log.info("validate");
        SysAclModuleMapper moduleMapper = ApplicationContextHelper.popBean(SysAclModuleMapper.class);
        SysAclModule module = moduleMapper.selectByPrimaryKey(1);
        log.info(JsonMapper.obj2String(module));
        BeanValidator.check(vo);
        return JsonData.success("test validate");
    }
}

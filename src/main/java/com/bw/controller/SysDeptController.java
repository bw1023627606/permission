package com.bw.controller;

import com.bw.common.JsonData;
import com.bw.param.DeptParam;
import com.bw.service.SysDeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @auther bai
 * @data 2019/5/24 - 16:53
 * @description
 */
@Controller
@RequestMapping("/sys/dept")
@Slf4j
public class SysDeptController {

    private SysDeptService sysDeptService;

    @RequestMapping("/save.json")
    @ResponseBody
    public JsonData saveDept(DeptParam param){
        sysDeptService.save(param);
        return JsonData.success();

    }


}

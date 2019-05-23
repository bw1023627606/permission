package com.bw.common;

import com.bw.exception.ParamException;
import com.bw.exception.PermissionException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理全局异常的类
 * @auther bai
 * @data 2019/5/23 - 10:03
 * @description
 */
@Slf4j
public class SpringExceptionResolve implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        String url = request.getRequestURL().toString();
        ModelAndView mv;
        String defaultMsg = "System error";

        //定义json请求.json后缀   页面为.page
        //这里我们要求项目中所有请求json数据，都是用.json结尾
        if(url.endsWith(".json")){
            if(ex instanceof PermissionException || ex instanceof ParamException){
                JsonData result = JsonData.fail(ex.getMessage());
                mv = new ModelAndView("jsonView",result.toMap());
            }else{
                log.error("unKnow json exception,url:"+url,ex);
                JsonData result = JsonData.fail(defaultMsg);
                mv = new ModelAndView("jsonView",result.toMap());
            }
        }else if(url.endsWith(".page")){//所有的page页面都是.page结尾
            log.error("unKnow page exception,url:"+url,ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("exception",result.toMap());

        }else{
            log.error("unKnow exception,url:"+url,ex);
            JsonData result = JsonData.fail(defaultMsg);
            mv = new ModelAndView("jsonView",result.toMap());
        }
        return mv;
    }
}

package com.bw.common;

import com.bw.util.JsonMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 6-7 Http请求前后监听工具-HttpInterceptor开发
 *可计算执行时间在请求签一个时间，after后一个时间
 * @auther bai
 * @data 2019/5/24 - 15:34
 * @description
 */
@Slf4j
public class HttpInterceptor extends HandlerInterceptorAdapter {

    private static  final String START_TIME = "requestStartTime";



    @Override
    /**
     * 处理请求之前触发
     */
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //当前的请求
        String url = request.getRequestURL().toString();
        //请求的参数
        Map parameterMap = request.getParameterMap();
        log.info("request start url:{},param:{}", url, JsonMapper.obj2String(parameterMap));
        long start = System.currentTimeMillis();
        request.setAttribute(START_TIME,start);
        //return true 可以保证请求处理之前是正常的
        return true;
    }

    @Override
    /**
     * 正常处理请求调用，不一定触发
     */
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //当前的请求
//        String url = request.getRequestURL().toString();
        //请求的参数
        Map parameterMap = request.getParameterMap();
//        long start = (long)request.getAttribute(START_TIME);
//        long end = System.currentTimeMillis();
//        log.info("request finished url:{},cosTime:{}", url, end-start);

    }

    @Override
    /**
     * 所有请求，异常也会调用,100%会触发
     */
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //当前的请求
        String url = request.getRequestURL().toString();
        //请求的参数
        Map parameterMap = request.getParameterMap();
        long start = (long)request.getAttribute(START_TIME);
        long end = System.currentTimeMillis();
        log.info("request complete url:{},cosTime:{}", url, end-start);
    }
}

package com.bw.common;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * 从applicationContext上下文去一个Bean
 * @auther bai
 * @data 2019/5/24 - 13:59
 * @description
 */
@Component("applicationContextHelper")
public class ApplicationContextHelper implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        applicationContext = context;
    }

    public static <T> T popBean(Class<T> clazz){
        if(applicationContext==null){
            return null;
        }
        return  applicationContext.getBean(clazz);
    }

    public static <T> T popBean(String name,Class<T> clazz){
        if(applicationContext==null){
            return null;
        }
        return applicationContext.getBean(name,clazz);
    }




}

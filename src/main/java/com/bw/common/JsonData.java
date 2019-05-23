package com.bw.common;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

/**
 * 处理json信息的工具
 * @auther bai
 * @data 2019/5/23 - 9:26
 * @description
 */
@Getter
@Setter
public class JsonData {
    //返回结果
    private boolean ret;
    //出现异常的msg
    private String msg;
    //返回前台的数据
    private Object data;

    public JsonData(boolean ret){
        this.ret=ret;
    }
    //全局的方法
    //1.成功的时候，同时返回msg信息

    /**
     * 成功的时候，同时返回msg信息
     * @param object
     * @param msg
     * @return
     */
    public static JsonData success(Object object,String msg){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        jsonData.msg = msg;
        return jsonData;
    }
    //2.成功的时候，不返回msg信息

    /**
     * 成功的时候，不返回msg信息
     * @param object
     * @return
     */
    public static JsonData success(Object object){
        JsonData jsonData = new JsonData(true);
        jsonData.data = object;
        return jsonData;
    }

    //3.成功的时候，不反悔msg信息，并且无返回数据，不传参数

    /**
     * 成功的时候，不反悔msg信息，并且无返回数据，不传参数
     * @return
     */
    public static JsonData success(){
        return new JsonData(true);
    }

    //4.失败时候的方法

    /**
     * 失败时候的方法
     * @param msg
     * @return
     */
    public static JsonData fail(String msg){
        JsonData jsonData = new JsonData(false);
        jsonData.msg = msg;
        return jsonData;
    }

    /**
     * 将信息转换为map集合的键值对
     * @return
     */
    public Map<String,Object> toMap(){
        HashMap<String,Object> result = new HashMap<String,Object>();
        result.put("ret",ret);
        result.put("msg",msg);
        result.put("data",data);
        return result;
    }


}

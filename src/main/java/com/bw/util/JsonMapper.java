package com.bw.util;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.codehaus.jackson.map.ser.impl.SimpleFilterProvider;
import org.codehaus.jackson.type.TypeReference;

import static jdk.nashorn.internal.runtime.regexp.joni.Config.log;

/**
 * 讲一个类转换成json或将一个json字符串转换成一个类
 * @auther bai
 * @data 2019/5/23 - 17:32
 * @description
 */
@Slf4j
public class JsonMapper {
    private static ObjectMapper objectMapper = new ObjectMapper();

    static{
        //config
        objectMapper.disable(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES);
        objectMapper.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS,false);
        objectMapper.setFilters(new SimpleFilterProvider().setFailOnUnknownId(false));
        objectMapper.setSerializationInclusion(JsonSerialize.Inclusion.NON_EMPTY);
    }

    public static <T> String obj2String(T src){
        if(src == null){
            return null;
        }
        try{
            return src instanceof String ? (String)src :objectMapper.writeValueAsString(src);
        }catch (Exception e){
            log.warn("parse object to String exception,error{}",e);
            return null;
        }
    }

    public static <T> T string2Obj(String src, TypeReference<T> typeReference){
        if(src==null || typeReference==null){
            return null;
        }
        try{
            return (T) (typeReference.getType().equals(String.class) ? src : objectMapper.readValue(src,typeReference));
        }catch (Exception e){
            log.warn("parse String to object exception,String:{},TypeReference<T>:{},error:{}",src,typeReference.getType(),e);
            return null;
        }
    }

}

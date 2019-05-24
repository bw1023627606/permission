package com.bw.util;

import org.apache.commons.lang3.StringUtils;

/**
 * 判断层级的工具类
 * @auther bai
 * @data 2019/5/24 - 17:02
 * @description
 */
public class LevelUtil {

    //各个层级的分隔符
    public final  static  String SEPARATOR = ".";
    //ROOT的ID,从0开始
    public final  static  String ROOT = "0";
    //部门level的计算规则


    //0
    //0.1
    //0.1.1
    //0.1.2
    //0.2.1
    public static  String calculateLevel(String parentLevel,int parentId){
        if(StringUtils.isBlank(parentLevel)){
            return ROOT;
        }else{
            return StringUtils.join(parentLevel,SEPARATOR,parentId);
        }
    }

}

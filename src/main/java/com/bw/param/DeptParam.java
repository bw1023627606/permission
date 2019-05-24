package com.bw.param;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 部门类的参数
 * @auther bai
 * @data 2019/5/24 - 16:42
 * @description
 */
@Setter
@Getter
@ToString
public class DeptParam {
    /**
     * 部门id
     */
    private Integer id;
    /**
     * 部门名称
     */
    @NotBlank(message = "部门名称不能为空")
    @Length(max = 15,min = 2,message = "部门名称要在2-15个之间")
    private String name;
    /**
     * 父部门id
     */
    private Integer parentId;
    /**
     * 顺序
     */
    @NotNull(message = "展示顺序不可为空")
    private Integer seq;
    /**
     * 备注
     */
    @Length(max = 150,message = "备注长度在150个字以内")
    private String remark;
}

package com.bw.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * 测试
 * @auther bai
 * @data 2019/5/23 - 14:53
 * @description
 */
@Getter
@Setter
public class TestVo {
    @NotBlank
    private String msg;
    @NotNull
    private Integer id;


}

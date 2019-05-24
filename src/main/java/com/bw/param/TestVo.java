package com.bw.param;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * 测试
 * @auther bai
 * @data 2019/5/23 - 14:53
 * @description
 */
@Getter
@Setter
public class TestVo {

    @NotNull
    private Integer id;
    @NotBlank
    private String msg;

    private List<String> str;

}

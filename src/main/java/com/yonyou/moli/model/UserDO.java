package com.yonyou.moli.model;

import org.springframework.data.annotation.Id;

/**
 * Created by Administrator on 2017/11/23.
 */
public class UserDO {

    @Id
    private Long id;

    private String name;

    private Integer age;

    private Double weight;

    private String sex;
}

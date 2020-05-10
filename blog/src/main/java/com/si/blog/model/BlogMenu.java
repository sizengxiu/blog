package com.si.blog.model;

import lombok.Data;

import java.util.Date;

/**
 * description
 *
 * @user Administrator
 * @date 2020/5/9 21:55
 */
@Data
public class BlogMenu {
    private Integer id;
    private String parentCode;
    private String code;
    private String name;
    private String url;
    private Date createTime;
    private Date updateTime;
}

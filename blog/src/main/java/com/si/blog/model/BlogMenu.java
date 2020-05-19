package com.si.blog.model;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updateTime;
}

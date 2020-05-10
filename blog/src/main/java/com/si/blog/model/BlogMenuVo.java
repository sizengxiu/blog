package com.si.blog.model;

import lombok.Data;

import java.util.List;

/**
 * @user szx
 * @date 2020/5/10 21:40
 */
@Data
public class BlogMenuVo {
    private String code;
    private String name;
    private String url;
    private List<BlogMenu> childList;
}

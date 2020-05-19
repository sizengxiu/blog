package com.si.blog.model;

import lombok.Data;

/**
 * @user szx
 * @date 2020/5/15 21:09
 */
@Data
public class BlogClickRankVo {
    private int id;
    private int blogId;
    private int clickTimes;
    private String blogName;
    private String blogUrl;
}

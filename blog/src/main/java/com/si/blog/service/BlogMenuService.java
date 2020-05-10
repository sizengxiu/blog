package com.si.blog.service;

import com.si.blog.model.BlogMenu;
import com.si.blog.model.BlogMenuVo;

import java.util.List;

/**
 * description
 *
 * @user szx
 * @date 2020/5/9 23:54
 */
public interface BlogMenuService {
    /**
     * 获取菜单列表
     * @return:
     * @auther: szx
     * @date: 2020/5/9 23:18
     */
    List<BlogMenuVo> getBlogMenuList();
}

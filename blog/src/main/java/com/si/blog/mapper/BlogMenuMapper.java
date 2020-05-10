package com.si.blog.mapper;

import com.si.blog.model.BlogMenu;
import com.si.blog.model.BlogMenuVo;

import java.util.List;

/**
 * 博客菜单
 *
 * @user szx
 * @date 2020/5/9 23:17
 */
public interface BlogMenuMapper {
    /**
     * 获取菜单列表
     * @return:
     * @auther: szx
     * @date: 2020/5/9 23:18
     */
    List<BlogMenuVo> getBlogMenuList();
}

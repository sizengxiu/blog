package com.si.blog.mapper;

import com.si.blog.model.BlogMenu;
import com.si.blog.model.BlogMenuVo;
import org.apache.ibatis.annotations.Param;

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

    /**
     * 根据日志分类获取日志列表
     * @param:
     * @return:
     * @auther: szx
     * @date: 2020/5/15 22:50
     */
    List<BlogMenu> getBlogMenuListByType(@Param("typeCode")String typeCode);
    /**
     *  获取所有日志信息
     * @param:
     * @return:
     * @auther: szx
     * @date: 2020/5/17 22:42
     */
    List<BlogMenu> getAllBlogInfo();


 }

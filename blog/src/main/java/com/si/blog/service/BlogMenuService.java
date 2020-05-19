package com.si.blog.service;

import com.si.blog.model.BlogClickRankVo;
import com.si.blog.model.BlogMenu;
import com.si.blog.model.BlogMenuVo;
import org.apache.ibatis.annotations.Param;

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
    /**
     * 记录日志点击
     * @param:
     * @return:
     * @auther: szx
     * @date: 2020/5/15 21:08
     */
    void clickBlog(int blogId);
    /**
     * 返回排行榜前limit个blog
     * @param: 条数
     * @return:
     * @auther: szx
     * @date: 2020/5/15 21:11
     */
    List<BlogClickRankVo> getClickRankByLimit(int start,int end);

    /**
     * 根据日志分类获取日志列表
     * @param:
     * @return:
     * @auther: szx
     * @date: 2020/5/15 22:50
     */
    List<BlogMenu> getBlogMenuListByType(String typeCode);
}

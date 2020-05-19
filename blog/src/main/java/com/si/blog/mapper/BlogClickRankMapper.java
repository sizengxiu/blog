package com.si.blog.mapper;

import com.si.blog.model.BlogClickRankVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @user szx
 * @date 2020/5/15 21:13
 */
public interface BlogClickRankMapper {
    /**
     * 获取点击列表
     * @param: 条数
     * @return:
     * @auther: szx
     * @date: 2020/5/15 21:11
     */
    List<BlogClickRankVo> getClickRankList(@Param("limit") int limit);

    /**
     * 新增点击日志
     * @param:
     * @return:
     * @auther: szx
     * @date: 2020/5/15 21:29
     */
    int addClickTimes(@Param("blogId") int blogId);

    /**
     * 日志点击次数+1
     * @param:  日志id
     * @return:
     * @auther: szx
     * @date: 2020/5/15 21:29
     */
    int addClickTimesByOne(@Param("blogId") int blogId);
}

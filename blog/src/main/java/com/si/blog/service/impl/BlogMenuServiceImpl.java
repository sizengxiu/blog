package com.si.blog.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.si.blog.mapper.BlogClickRankMapper;
import com.si.blog.mapper.BlogMenuMapper;
import com.si.blog.model.BlogClickRankVo;
import com.si.blog.model.BlogMenu;
import com.si.blog.model.BlogMenuVo;
import com.si.blog.service.BlogMenuService;
import com.si.blog.util.RedisUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @user szx
 * @date 2020/5/9 23:55
 */
@Service
@Slf4j
public class BlogMenuServiceImpl implements BlogMenuService, InitializingBean {
    /**
     * redis点击排行的key
     */
    public static final String CLICK_RANK_KEY = "click_rank_zset";
    @Autowired
    private BlogMenuMapper blogMenuMapper;
    @Autowired
    private BlogClickRankMapper blogClickRankMapper;
    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    public List<BlogMenuVo> getBlogMenuList() {
        return blogMenuMapper.getBlogMenuList();
    }

    @Override
    public void clickBlog(int blogId) {
        Double score = redisTemplate.opsForZSet().score(CLICK_RANK_KEY, blogId);
        if (score == null) {
            blogClickRankMapper.addClickTimes(blogId);
        } else {
            blogClickRankMapper.addClickTimesByOne(blogId);
        }
        redisTemplate.opsForZSet().incrementScore(CLICK_RANK_KEY, blogId, 1);
    }

    @Override
    public List<BlogClickRankVo> getClickRankByLimit(int start, int end) {
        Set<Integer> set = redisTemplate.opsForZSet().range(CLICK_RANK_KEY, start, end);
        //TODO 这个地方正在测试
        List<BlogMenu> list = redisTemplate.executePipelined(new RedisCallback<BlogMenu>() {
            @Override
            public BlogMenu doInRedis(RedisConnection connection) throws DataAccessException {
                for (Integer i : set) {
                    connection.get((i + "").getBytes());
                }
                return null;
            }
        });
        System.out.println(list.toString());
        return null;
    }

    @Override
    public List<BlogMenu> getBlogMenuListByType(String typeCode) {
        return blogMenuMapper.getBlogMenuListByType(typeCode);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        List<BlogMenu> list = blogMenuMapper.getAllBlogInfo();
        redisTemplate.executePipelined(new RedisCallback<String>() {
            @Override
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                for (BlogMenu blogMenu : list) {
                    connection.set(JSONObject.toJSONString(blogMenu.getId()).getBytes(), JSONObject.toJSONString(blogMenu).getBytes());
                }
                return null;
            }
        });
        getClickRankByLimit(0,19);
    }

    private void test( List<BlogMenu> list){
        BlogMenu blogMenu = list.get(0);
        redisTemplate.opsForValue().set("100",JSONObject.toJSONString(blogMenu));
    }
}

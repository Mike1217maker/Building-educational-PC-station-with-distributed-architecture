package com.lagou.user.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.entity.User;
import com.lagou.user.UserService;
import mapper.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;


/**
 * 用户表(User)表服务实现类
 *
 * @author Zhao YuanWei
 * @since 2022-04-08 10:55:49
 */
@Service //暴露服务：让消费者能够找到我
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    public User login(String phone, String password) {

        return userDao.login(phone, password);

    }

    public Integer checkPhone(String phone) {
        return userDao.checkPhone(phone);
    }

    public Integer register(String phone, String password,String nickname,String headimg) {
        return userDao.register(phone, password,nickname, headimg);
    }
}
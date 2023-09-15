package com.lagou.order.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.entity.Course;
import com.lagou.entity.UserCourseOrder;
import com.lagou.order.OrderService;
import mapper.CourseDao;
import mapper.OrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @BelongsProject: lagou-edu
 * @Author: Zhao YuanWei
 * @CreateTime: 2024-05-09 16:00
 * @Description:
 */
@Service //暴露服务
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;




    public void saveOrder(String orderNo, String user_id, String course_id, String activity_course_id, String source_type) {
        orderDao.saveOrder(orderNo, user_id, course_id, activity_course_id, source_type);
    }

    public Integer updateOrder(String orderNo, int status) {
        Integer integer = orderDao.updateOrder(orderNo, status);
        return integer;
    }

    public Integer deleteOrder(String orderNo) {
        Integer integer = orderDao.deleteOrder(orderNo);
        return integer;
    }
    public List<UserCourseOrder> getOrdersByUserId(String userId) {
        List<UserCourseOrder> ordersByUserId = orderDao.getOrdersByUserId(userId);
        return ordersByUserId;
    }
}

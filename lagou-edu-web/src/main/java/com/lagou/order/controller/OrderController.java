package com.lagou.order.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.entity.Course;
import com.lagou.entity.UserCourseOrder;
import com.lagou.order.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

/**
 * @BelongsProject: lagou-edu-web
 * @Author: Zhao YuanWei
 * @CreateTime: 2022-06-09 16:11
 * @Description:
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Reference // 远程消费
    private OrderService orderService;



    @GetMapping("saveOrder/{orderNo}/{user_id}/{course_id}/{activity_course_id}/{source_type}")
    public String saveOrder(@PathVariable("orderNo")String orderNo,@PathVariable("user_id")String user_id , @PathVariable("course_id")String course_id,@PathVariable("activity_course_id")String activity_course_id,@PathVariable("source_type")String source_type) {
        orderService.saveOrder(orderNo, user_id, course_id, activity_course_id, source_type);
        return orderNo;
    }

    @GetMapping("updateOrder/{orderNo}/{status}")
    public Integer updateOrder(@PathVariable("orderNo")String orderNo , @PathVariable("status")Integer status) {
        System.out.println("订单编号 = " + orderNo);
        System.out.println("状态编码 = " + status);
        Integer integer = orderService.updateOrder(orderNo, status);
        System.out.println("订单更新 = " + integer);
        return integer;
    }

    @GetMapping("deleteOrder/{orderno}")
    public Integer deleteOrder(@PathVariable("orderno")String orderno ) {
        Integer integer = orderService.deleteOrder(orderno);
        return integer;
    }

    @GetMapping("getOrdersByUserId/{userid}")
    public List<UserCourseOrder> getOrdersByUserId(@PathVariable("userid")String userid ) {
        List<UserCourseOrder> list = orderService.getOrdersByUserId(userid);
        return list;
    }

}

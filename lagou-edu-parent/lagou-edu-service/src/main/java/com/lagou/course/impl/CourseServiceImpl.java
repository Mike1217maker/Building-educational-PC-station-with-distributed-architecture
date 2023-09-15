package com.lagou.course.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.lagou.course.CourseService;
import com.lagou.entity.Course;
import mapper.CourseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.List;

/**
 * @BelongsProject: lagou-edu
 * @Author: Zhao YuanWei
 * @CreateTime: 2022-04-08 16:46
 * @Description:
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseDao courseDao;

    @Autowired
    private RedisTemplate redisTemplate;
    @Cacheable(key = "allCourse",value = "getAllCourse")
    public List<Course> getAllCourse() {
        List<Course>  allCourse = courseDao.getAllCourse();
        redisTemplate.opsForSet().add("allCourse",allCourse);
        return allCourse;
    }

    @Override
    public List<Course> getCourseByUserId(Integer userId) {
        return courseDao.getCourseByUserId(userId);
    }



    public Course getCourseById(Integer courseid) {
        return courseDao.getCourseById(courseid);
    }
}

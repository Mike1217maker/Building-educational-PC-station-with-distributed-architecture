package mapper;

import com.lagou.entity.Course;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @BelongsProject: lagou-edu
 * @Author: Zhao YuanWei
 * @CreateTime: 2022-04-08 16:24
 * @Description:
 */
@Service
public interface CourseDao {

    /**
     * 查询全部课程信息
     * @return
     */
    List<Course> getAllCourse();

    /**
     * 查询已登录用户购买的全部课程信息
     * @return
     */
    List<Course> getCourseByUserId(@Param("userId") Integer userId);

    /**
     * 查询某门课程的详细信息
     * @param courseid 课程编号
     * @return
     */
    Course getCourseById(@Param("courseid") Integer courseid);
}

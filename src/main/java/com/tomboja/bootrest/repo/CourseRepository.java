package com.tomboja.bootrest.repo;

import com.tomboja.bootrest.domain.Course;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

@Repository
public class CourseRepository {
    private List<Course> courseList = new ArrayList<>();
    public List<Course> getCourseList() {
        if (courseList.size() == 0) {
            Course c = new Course(1, "CS50", "WAA");
            courseList.add(c);
            c = new Course(2, "CS51", "WAP");
            courseList.add(c);
        }
        return courseList;
    }
}

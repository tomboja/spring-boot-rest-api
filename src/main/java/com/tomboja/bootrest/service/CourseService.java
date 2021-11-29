package com.tomboja.bootrest.service;

import com.tomboja.bootrest.domain.Course;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: IntelliJ IDEA
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

@Service
public interface CourseService {
    public List<Course> getCourseList();
}

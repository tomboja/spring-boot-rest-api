package com.tomboja.bootrest.controller;

import com.tomboja.bootrest.domain.Course;
import com.tomboja.bootrest.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ProjectName: Spring Rest api
 * @Author: tdessalegn
 * @Date: 11/27/21
 */

@RestController
//@Controller is for returning view. But here we use rest controller
@RequestMapping("/courses")
public class CourseController {

    // Domain, Repository, Resource, Entity all mean the domain model

    @Autowired
    private CourseService courseService;

    @GetMapping
    public String hello(@RequestParam String name) {
        return "Hello " + name;
    }

    @GetMapping("/{year}/{data}")
    public String hello2(@PathVariable String year, @PathVariable String data) {
        return "Year " + year + " " + data;
    }

    @GetMapping("/getAllCourses")
    public  List<Course> courseList() {
        return courseService.getCourseList();
    }

    @PostMapping
    public void doPost() {
        System.out.println("This is from Post ");
    }

    @PostMapping("/{year}")
    public void testPost(@PathVariable String year) {
        System.out.println("Year = " + year);
    }
}

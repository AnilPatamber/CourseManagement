package com.shadow.coursemngt.controllers;

import com.shadow.coursemngt.entities.Course;
import com.shadow.coursemngt.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courseapi")
public class CourseController {
    @Autowired
    CourseService courseService;
    @GetMapping("/courses")
    public String getAllCourses(Model model)
    {
        model.addAttribute("courses", courseService.getCourse());
        return "courseview";
    }
    @GetMapping
    public String hello()
    {
        return "Welcome to the spring boot project";
    }

    @PostMapping("/")
    public String addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
        return "course added successfully";
    }
    @PutMapping("/")
    public void updateCourse(@RequestBody Course course)
    {
        courseService.updateCourse(course);
    }
    @DeleteMapping("/{id}")
    public String deleteCourse(@PathVariable String id)
    {
        int idint = Integer.parseInt(id);
        courseService.deleteCourse(idint);
        return "Course with id as "+id+" has been deleted successfully";
    }

}

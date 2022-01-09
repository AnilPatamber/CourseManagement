package com.shadow.coursemngt.services;

import com.shadow.coursemngt.entities.Course;
import com.shadow.coursemngt.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {
    @Autowired
    CourseRepository courserepo;

   public List<Course> getCourse()
   {
      Iterable<Course> itr = courserepo.findAll();
       List<Course> courses = new ArrayList<>();
       itr.forEach(courses::add);
       return courses;
   }
   public void addCourse(Course course)
   {
       courserepo.save(course);
   }

    public void updateCourse(Course course) {
       courserepo.save(course);
    }

    public void deleteCourse(int id) {
       courserepo.deleteById(id);

    }
}


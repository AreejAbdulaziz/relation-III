package com.example.jparelationi.Service;

import com.example.jparelationi.Api.ApiException;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Student;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {
    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;
    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void addCourse(Course course){
        courseRepository.save(course);
    }

    public void updateCourse(Integer id,Course course){
        Course oldCourse=courseRepository.findCourseById(id);
        if(oldCourse==null){
            throw new ApiException("course not found");
        }
        oldCourse.setName(course.getName());
        courseRepository.save(oldCourse);
    }

    public void deleteCourse(Integer id){
        Course course=courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("course not found");
        }
        courseRepository.delete(course);
    }
    public String returnTeacherName(Integer id){
        Course course=courseRepository.findCourseById(id);
        if(course==null){
            throw new ApiException("course not found!");
        }

        Teacher teacher=teacherRepository.findTeacherById(course.getTeacher().getId());
        if(teacher==null){
            throw new ApiException("teacher not found!");
        }
        return teacher.getName();
    }
    //2
    public List<Student> getAllStudents(Integer courseIs){
        Course course=courseRepository.findCourseById(courseIs);
        if(course==null){
            throw new ApiException("course not found");
        }
        return course.getStudents().stream().toList();
    }
}

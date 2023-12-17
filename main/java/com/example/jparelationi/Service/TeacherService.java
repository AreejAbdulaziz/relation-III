package com.example.jparelationi.Service;

import com.example.jparelationi.Api.ApiException;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final CourseRepository courseRepository;
    public List<Teacher> getAllTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public void updateTeacher(Integer teacherId,Teacher teacher){
        Teacher oldTeacher=teacherRepository.findTeacherById(teacherId);
        if(oldTeacher==null){
            throw new ApiException("teacher not found");
        }
        oldTeacher.setName(teacher.getName());
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setEmail(teacher.getEmail());
        oldTeacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldTeacher);
    }
    public void deleteTeacher(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("teacher not found");
        }
        teacherRepository.delete(teacher);
    }
    public Teacher findTeacherById(Integer id){
        Teacher teacher=teacherRepository.findTeacherById(id);
        if(teacher==null){
            throw new ApiException("teacher not found");
        }
        return teacher;
    }

    public void assignTeacherToCourse(Integer teacher_id,Integer course_id){
        Teacher teacher=teacherRepository.findTeacherById(teacher_id);
        Course course=courseRepository.findCourseById(course_id);

        if(teacher==null||course==null){
            throw new ApiException("teacher or course not found");
        }

        course.setTeacher(teacher);

        courseRepository.save(course);
    }

}

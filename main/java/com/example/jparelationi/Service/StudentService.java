package com.example.jparelationi.Service;

import com.example.jparelationi.Api.ApiException;
import com.example.jparelationi.Model.Course;
import com.example.jparelationi.Model.Student;
import com.example.jparelationi.Repository.CourseRepository;
import com.example.jparelationi.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public void addStudent(Student student){
        studentRepository.save(student);
    }

    public void updateStudent(Integer id,Student student){
        Student oldStudent=studentRepository.findStudentById(id);
        if(oldStudent==null){
            throw new ApiException("student not found");
        }
        oldStudent.setName(student.getName());
        oldStudent.setAge(student.getAge());
        oldStudent.setMajor(student.getMajor());

        studentRepository.save(oldStudent);
    }

    public void deleteStudent(Integer id){
        Student student=studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("student not found");
        }
        studentRepository.delete(student);
    }

    public void assignStudentsAndCourses(Integer studentId,Integer courseId){
        Student student=studentRepository.findStudentById(studentId);
        Course course=courseRepository.findCourseById(courseId);

        if(student==null||course==null){
            throw new ApiException("you cant complete relation");
        }
        student.getCourses().add(course);
        course.getStudents().add(student);

        studentRepository.save(student);
        courseRepository.save(course);
    }

    //1
    public void changeMajor(Integer id , String major){
        Student student=studentRepository.findStudentById(id);
        if(student==null){
            throw new ApiException("student not found");
        }
        if(student!=null){
            for (Course c:student.getCourses()){
                c.getStudents().remove(student);
                courseRepository.save(c);
            }
        }
        student.setMajor(major);
        student.setCourses(null);

        studentRepository.save(student);
        }

    }


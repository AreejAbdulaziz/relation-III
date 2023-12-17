package com.example.jparelationi.Controller;

import com.example.jparelationi.Model.Student;
import com.example.jparelationi.Service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;
    @GetMapping("/get")
    public ResponseEntity getAllStudents(){
        return ResponseEntity.status(200).body(studentService.getAllStudents());
    }
    @PostMapping("/add")
    public ResponseEntity addStudent(@RequestBody@Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(200).body("student added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateStudent(@PathVariable Integer id,@RequestBody@Valid Student student){
        studentService.updateStudent(id, student);
        return ResponseEntity.status(200).body("student updated!");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return ResponseEntity.status(200).body("student deleted!");
    }
    @PutMapping("/{studentId}/assign/{courseId}")
    public ResponseEntity assignStudentsAndCourses(@PathVariable Integer studentId,@PathVariable Integer courseId){
        studentService.assignStudentsAndCourses(studentId, courseId);
        return ResponseEntity.status(200).body("done");
    }
    @PutMapping("/change/{id}/{major}")
    public ResponseEntity changeMajor(@PathVariable Integer id,@PathVariable String major){
        studentService.changeMajor(id, major);
        return ResponseEntity.status(200).body("major changed!");
    }
}

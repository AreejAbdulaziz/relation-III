package com.example.jparelationi.Controller;

import com.example.jparelationi.Model.Teacher;
import com.example.jparelationi.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/teacher")
@AllArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    @GetMapping("/get")
    public ResponseEntity getAllTeachers(){
        return ResponseEntity.status(200).body(teacherService.getAllTeachers());
    }
    @PostMapping("/add")
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher added!");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacher(@PathVariable Integer id,@RequestBody@Valid Teacher teacher){
        teacherService.updateTeacher(id,teacher);
        return ResponseEntity.status(200).body("teacher updated");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body("teacher deleted!");
    }
    @GetMapping("/getOne/{teacherId}")
    public ResponseEntity findTeacherById(@PathVariable Integer teacherId){
        return ResponseEntity.status(200).body(teacherService.findTeacherById(teacherId));
    }
    @PutMapping("/{teacher_id}/assign/{course_id}")
    public ResponseEntity assignTeacherToCourse(@PathVariable Integer teacher_id,@PathVariable Integer course_id){
        teacherService.assignTeacherToCourse(teacher_id, course_id);
        return ResponseEntity.status(200).body("assign dine!");
    }
}

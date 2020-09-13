package com.thoughtworks.capability.gtb.restfulapidesign.controller;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(@RequestParam(required = false) Gender gender){
        return studentService.getAllStudents(gender);
    }

    @PostMapping("/students")
    public void addStudent(@RequestBody Student student){
        studentService.saveStudent(student);
    }

    @DeleteMapping("/students/{id}")
    public void deleteStudent(@PathVariable Integer id) {
        studentService.deleteStudent(id);
    }

    @GetMapping("/students/{id}")
    public Student getStudent(@PathVariable Integer id) {
        return studentService.getStudent(id);
    }

}

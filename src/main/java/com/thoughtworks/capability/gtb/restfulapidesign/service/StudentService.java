package com.thoughtworks.capability.gtb.restfulapidesign.service;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Team;
import com.thoughtworks.capability.gtb.restfulapidesign.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAllStudents(Gender gender) {
        if(gender == null){
            System.out.println("gender is null");
            return studentRepository.findAll();

        }
        System.out.println(gender);
        return studentRepository.findAllByGender(gender);
    }

    public void saveStudent(Student student) { studentRepository.save(student); }

    public void deleteStudent(Integer studentId) { studentRepository.deleteById(studentId); }

    public Student getStudent(Integer studentId) { return studentRepository.findById(studentId); }

    public void updateStudent(Integer studentId, Student student) {
        studentRepository.updateById(studentId, student);
    }
}

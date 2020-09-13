package com.thoughtworks.capability.gtb.restfulapidesign.repository;

import com.thoughtworks.capability.gtb.restfulapidesign.domain.Gender;
import com.thoughtworks.capability.gtb.restfulapidesign.domain.Student;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class StudentRepository {
    private final List<Student> studentList = new ArrayList<>();
//    {
//        studentList.add(Student.builder().id(1).name("沈乐棋").build());
//        studentList.add(Student.builder().id(2).name("徐慧慧").build());
//        studentList.add(Student.builder().id(3).name("陈思聪").build());
//        studentList.add(Student.builder().id(4).name("王江林").build());
//        studentList.add(Student.builder().id(5).name("王登宇").build());
//        studentList.add(Student.builder().id(6).name("杨思雨").build());
//        studentList.add(Student.builder().id(7).name("江雨舟").build());
//    }

    public List<Student> findAll() {
        return new ArrayList<>(studentList);
    }

    public List<Student> findAllByGender(Gender gender) {
        //return studentList.stream().filter(student -> student.getGender() == gender).collect(Collectors.toList());
        System.out.println(studentList.stream().filter(student -> student.getGender() == gender).collect(Collectors.toList()));
        return new ArrayList<>(studentList.stream().filter(student -> student.getGender() == gender).collect(Collectors.toList()));
    }

    public Student findById(Integer studentId) {
        return studentList.stream().filter(student -> student.getId() == studentId).findAny().orElse(null);
    }

    public void save(Student student) {
        studentList.add(student);
    }

    public void deleteById(Integer studentId) {
        Student student = findById(studentId);
        studentList.remove(student);
    }

}

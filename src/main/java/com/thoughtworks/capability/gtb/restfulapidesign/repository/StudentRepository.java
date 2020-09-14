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

    public List<Student> findAll() {
        return new ArrayList<>(studentList);
    }

    public List<Student> findAllByGender(Gender gender) {
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

    public void updateById(Integer studentId, Student student) {
        Student oldStudent = findById(studentId);
        if (student.getGender() != null) oldStudent.setGender(student.getGender());
        if (student.getName() != null) oldStudent.setName(student.getName());
        if (student.getNote() != null) oldStudent.setNote(student.getNote());
    }
}

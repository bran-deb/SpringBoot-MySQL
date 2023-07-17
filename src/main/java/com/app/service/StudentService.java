package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.app.model.domain.Student;

public interface StudentService {

    public List<Student> getAll();

    public Optional<Student> getStudent(Long id);

    public ResponseEntity<Object> saveUpdateStudent(Student student);

    public ResponseEntity<Object> deleteStudent(Long id);
}

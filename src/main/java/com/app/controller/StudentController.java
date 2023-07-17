package com.app.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.domain.Student;
import com.app.service.StudentService;

@RestController
@RequestMapping("/api/student")
public class StudentController {

    // @Qualifier("studentService")
    @Autowired
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @GetMapping("/{studentId}")
    public Optional<Student> getStudent(@PathVariable("studentId") Long id) {
        return studentService.getStudent(id);
    }

    @PostMapping("/")
    public ResponseEntity<Object> addStudent(@RequestBody Student student) {
        return studentService.saveUpdateStudent(student);
    }

    @PutMapping("/")
    public ResponseEntity<Object> updateStudent(@RequestBody Student student) {
        return studentService.saveUpdateStudent(student);
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Object> deleteStudent(@PathVariable("studentId") Long id) {
        return studentService.deleteStudent(id);
    }
}

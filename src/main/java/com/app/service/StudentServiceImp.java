package com.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.app.model.domain.Student;
import com.app.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {

    @Autowired
    StudentRepository studentRepository;

    HashMap<String, Object> response;

    public StudentServiceImp() {
    }

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudent(Long id) {
        return studentRepository.findById(id);
    }

    @Override
    public ResponseEntity<Object> saveUpdateStudent(Student student) {
        Optional<Student> studentExist = this.studentRepository.findByEmail(student.getEmail());
        response = new HashMap<>();

        if (studentExist.isPresent() && student.getEmail() == null) {
            response.put("error", HttpStatusCode.valueOf(400));
            response.put("message", "Ya existe un Estudiante con ese nombre");
            return new ResponseEntity<>(response, HttpStatusCode.valueOf(400));
        }
        response.put("message", "Estudiante creado con exito");

        if (student.getId() != null) {
            response.put("data", student);
            response.put("message", "Estudiante actualizado con exito");
        }

        this.studentRepository.save(student);
        response.put("data", student);
        return new ResponseEntity<>(response, HttpStatus.valueOf(201));
    }

    @Override
    public ResponseEntity<Object> deleteStudent(Long id) {
        Boolean isStudentExist = studentRepository.existsById(id);
        response = new HashMap<>();

        if (!isStudentExist) {
            response.put("error", HttpStatusCode.valueOf(400));
            response.put("message", "El estudiante no existe");
            return new ResponseEntity<Object>(response, HttpStatusCode.valueOf(404));
        }

        studentRepository.deleteById(id);
        response.put("data", studentRepository.findAll());
        response.put("message", "El estudiante con id: " + id + " fue eliminado correctamente");
        return new ResponseEntity<Object>(response, HttpStatusCode.valueOf(200));
    }
}

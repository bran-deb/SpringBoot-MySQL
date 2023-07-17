package com.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.app.service.StudentService;
import com.app.service.StudentServiceImp;

@Configuration
public class AppConfig {

    @Bean(name = "studentService")
    StudentService getStudentService() {
        return new StudentServiceImp();
    }
}

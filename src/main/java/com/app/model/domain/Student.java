package com.app.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import static jakarta.persistence.GenerationType.IDENTITY;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Component
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    // @Column(nullable = false)
    private String firstName;

    // @Column(nullable = false)
    private String lastName;

    @Column(name = "email", unique = true, nullable = false)
    private String email;
}

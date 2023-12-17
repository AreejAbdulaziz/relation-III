package com.example.jparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "student name cannot be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "student age cannot be null")
    @Positive(message = "enter correct age")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @NotNull(message = "major cannot be null")
    @Column(columnDefinition = "varchar(20) not null ")
    private String major;

    @ManyToMany(mappedBy = "students")
    private Set<Course> courses;
}

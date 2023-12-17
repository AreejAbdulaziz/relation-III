package com.example.jparelationi.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
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
@Entity
@NoArgsConstructor
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull(message = "teacher name cannot be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;
    @NotNull(message = "teacher age cannot be null")
    @Column(columnDefinition = "int not null")
    private Integer age;
    @Email(message = "enter correct email")
    @NotNull(message = "email cannot be null")
    @Column(columnDefinition = "varchar(20) unique not null")
    private String email;
    @Positive(message = "enter correct salary")
    @NotNull(message = "salary cannot be null")
    @Column(columnDefinition = "float not null")
    private double salary;

    @OneToOne(cascade = CascadeType.ALL , mappedBy = "teacher") //يحدد كيف الشي اللي فيني بياثر عليك
    @PrimaryKeyJoinColumn
    private Address address;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "teacher")
    private Set<Course> courses;
}

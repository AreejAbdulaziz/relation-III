package com.example.jparelationi.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Address {
    @Id
    private Integer id;
    @Column(columnDefinition = "varchar(200) not null")
    private String area;
    @Column(columnDefinition = "varchar(20) not null")
    private String street;
    @Column(columnDefinition = "varchar(20) not null")
    private Integer building_number;


    @OneToOne
    @MapsId
    @JsonIgnore//عشان ما تصير عملية استدعاء لا نهائيه
    private Teacher teacher;
}

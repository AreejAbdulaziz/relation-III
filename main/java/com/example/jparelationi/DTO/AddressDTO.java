package com.example.jparelationi.DTO;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {

    private Integer teacher_Id;
    @Size(max = 200,message = "area cannot be more than 200 characters")
    @NotNull(message = "area cannot be null")
    private String area;
    @Size(min = 4,message = "street more than 3 letters")
    @NotNull(message = "street cannot be null")
    private String street;
    @PositiveOrZero(message = "enter correct number")
    @NotNull(message = "building number cannot be null")
    private Integer building_number;
}

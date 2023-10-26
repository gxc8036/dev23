package com.gus.dev23.vo;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Emp {
    @NotBlank(message = "Name is not null") String name;

    @Min(value = 18, message = "Age must be greater than or equal to 18") int age;
}

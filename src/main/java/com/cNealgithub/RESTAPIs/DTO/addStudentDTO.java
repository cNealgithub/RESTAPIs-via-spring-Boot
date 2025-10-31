package com.cNealgithub.RESTAPIs.DTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class addStudentDTO {

    @NotBlank(message = "Name is required")
    private String name;
    @Email
    @NotBlank(message = "Valid Email is required")
    private String email;
}

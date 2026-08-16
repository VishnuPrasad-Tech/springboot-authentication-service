package com.vishnu.springboot_authentication_service.dto.requestDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {

    @NotBlank(message = "Email is Required")
    @Email(message = "Invalid Email Format")
    private String email;

    @NotBlank(message = "Password is Required")
    private String password;
}

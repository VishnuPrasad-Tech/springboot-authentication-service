package com.vishnu.springboot_authentication_service.controller;

import com.vishnu.springboot_authentication_service.dto.requestDTO.LoginRequest;
import com.vishnu.springboot_authentication_service.dto.requestDTO.SignupRequest;
import com.vishnu.springboot_authentication_service.dto.responseDTO.SignupResponse;
import com.vishnu.springboot_authentication_service.service.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService){
        this.authService=authService;
    }

    @PostMapping("/auth/signup")
    public SignupResponse signup(@RequestBody SignupRequest request){
        return authService.signup(request);

    }

    @PostMapping("/auth/login")
    public void login(@RequestBody LoginRequest request){
        authService.login(request);
    }


}

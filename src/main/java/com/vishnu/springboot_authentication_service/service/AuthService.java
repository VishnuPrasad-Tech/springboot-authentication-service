package com.vishnu.springboot_authentication_service.service;

import com.vishnu.springboot_authentication_service.dto.requestDTO.LoginRequest;
import com.vishnu.springboot_authentication_service.dto.requestDTO.SignupRequest;
import com.vishnu.springboot_authentication_service.dto.responseDTO.SignupResponse;
import com.vishnu.springboot_authentication_service.entity.User;
import com.vishnu.springboot_authentication_service.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthService(UserRepository userRepository,PasswordEncoder passwordEncoder){
        this.userRepository=userRepository;
        this.passwordEncoder=passwordEncoder;
    }



    public SignupResponse signup(SignupRequest request){
        if(userRepository.findByEmail(request.getEmail()).isPresent()){
            throw new RuntimeException("Email already registered");
        }
        String passwordHash=passwordEncoder.encode(request.getPassword());

        User user= new User(request.getEmail(), passwordHash);
        userRepository.save(user);

        return new SignupResponse("User Registered Successfully");
    }

    public void login(LoginRequest request){
        User user=  userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email or password"));

        if(!passwordEncoder.matches(request.getPassword(),user.getPasswordHash())){
            throw new RuntimeException("Invalid email or password");
        }
    }


}

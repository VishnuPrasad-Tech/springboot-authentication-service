package com.vishnu.springboot_authentication_service.dto.responseDTO;

import lombok.Getter;

@Getter
public class SignupResponse {

    private String message;

    public SignupResponse(String userRegisteredSuccessfully) {
        this.message=userRegisteredSuccessfully;
    }

}

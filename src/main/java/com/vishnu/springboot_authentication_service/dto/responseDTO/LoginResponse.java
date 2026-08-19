package com.vishnu.springboot_authentication_service.dto.responseDTO;

import lombok.Getter;

@Getter
public class LoginResponse {
    private String accessToken;
    private String tokenType;

    public LoginResponse(String accessToken,String tokenType){
        this.accessToken=accessToken;
        this.tokenType=tokenType;
    }

}

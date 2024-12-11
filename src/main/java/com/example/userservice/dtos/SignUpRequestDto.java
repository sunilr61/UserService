package com.example.userservice.dtos;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SignUpRequestDto {
    private String name;
    private String email;
    private String password;

}

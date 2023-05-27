package org.recsys.DTOs;

import lombok.Data;

@Data
public class SigninRequestDto {
    private String email;

    private String password;

}

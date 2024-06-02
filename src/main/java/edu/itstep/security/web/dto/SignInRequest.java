package edu.itstep.security.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Schema(description = "Authentication Request")
public class SignInRequest {

    @Schema(description = "Username", example = "Petro")
    @Size(min = 5, max = 50, message = "Username should be from 5 to 50 symbols")
    @NotBlank(message = "Username cannot be blank")
    private String username;

    @Schema(description = "Password", example = "some_password@4")
    @Size(min = 8, max = 255, message = "Password length should be from 8 to 255 symbols")
    @NotBlank(message = "Password cannot be blank")
    private String password;
}
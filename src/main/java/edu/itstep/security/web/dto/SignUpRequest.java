package edu.itstep.security.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "Sign up request")
public class SignUpRequest {

    @Schema(description = "Username", example = "Petro")
    @Size(min = 5, max = 50, message = "Username should be from 5 to 50 symbols")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Schema(description = "Email", example = "someemail@gmail.com")
    @Size(min = 5, max = 255, message = "Email length should be from 5 to 255 symbols")
    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Incorrect email format. Example: user@example.com")
    private String email;

    @Schema(description = "Password", example = "some_password@4")
    @Size(max = 255, message = "Password length cannot be longer than 255 symbols")
    private String password;
}
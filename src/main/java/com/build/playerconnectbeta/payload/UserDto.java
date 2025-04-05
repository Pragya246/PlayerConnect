package com.build.playerconnectbeta.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;
import java.util.Optional;

@Data
public class UserDto {
    private int userId;

    @NotEmpty
    @Size(min = 2, max = 50, message = "Name should be of atleast 2 characters.")
    private String name;

    @NotEmpty
    private String phoneNo;

    private List<String> games;

    private String address;

    @Email
    private String email;

    @NotEmpty
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$", message = "Password should be atleast 8 chars, Contains at least one digit, one lower alpha char and one upper alpha char, does not contain space.")
    private String password;
}

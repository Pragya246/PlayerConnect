package com.build.playerconnectbeta.payload;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class VenueMasterDto {

    @NotEmpty
    @Size(min = 1, max = 50, message = "Name should be of atleast 1 characters.")
    private String name;
    @Pattern(regexp = "^[6-9]\\d{9}$")
    private String phoneNo;
    @NotEmpty
    private String address;


}

package com.build.playerconnectbeta.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ApiResponse {

    String message;
    boolean status;

}

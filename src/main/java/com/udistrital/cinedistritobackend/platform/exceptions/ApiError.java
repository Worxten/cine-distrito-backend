package com.udistrital.cinedistritobackend.platform.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiError {
    private String error;
    private String message;
    private Integer status;
}

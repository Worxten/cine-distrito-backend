package com.udistrital.cinedistritobackend.platform.exceptions.api;

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

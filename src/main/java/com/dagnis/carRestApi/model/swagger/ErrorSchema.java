package com.dagnis.carRestApi.model.swagger;

import lombok.Data;

@Data
public class ErrorSchema {
    private String timestamp;
    private Integer status;
    private String error;
    private String path;
}

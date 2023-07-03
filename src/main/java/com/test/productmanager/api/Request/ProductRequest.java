package com.test.productmanager.api.Request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ProductRequest {

    @NotBlank
    private String name;
}

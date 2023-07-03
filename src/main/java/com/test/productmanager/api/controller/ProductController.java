package com.test.productmanager.api.controller;

import com.test.productmanager.api.Request.ProductRequest;
import com.test.productmanager.api.response.ProductResponse;
import com.test.productmanager.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    @ResponseStatus(OK)
    public List<ProductResponse> getAll() {
        return productService.getProductList();
    }

    @PostMapping
    @ResponseStatus(CREATED)
    public void create(@RequestBody ProductRequest productRequest) {
        productService.createProduct(productRequest);
    }
}

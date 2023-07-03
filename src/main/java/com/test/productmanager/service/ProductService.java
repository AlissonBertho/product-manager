package com.test.productmanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.productmanager.api.Request.ProductRequest;
import com.test.productmanager.api.response.ProductResponse;
import com.test.productmanager.entity.ProductEntity;
import com.test.productmanager.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;

    public List<ProductResponse> getProductList() {
        List<ProductEntity> products = productRepository.findAll();

        return products.parallelStream()
                .map(e -> objectMapper.convertValue(e, ProductResponse.class))
                .collect(Collectors.toList());
    }

    public void createProduct(ProductRequest productRequest) {
        ProductEntity productEntity = objectMapper.convertValue(productRequest, ProductEntity.class);
        productEntity.setId(UUID.randomUUID().toString());

        productRepository.save(productEntity);
    }

}

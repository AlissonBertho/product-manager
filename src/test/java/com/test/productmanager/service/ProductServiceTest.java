package com.test.productmanager.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.productmanager.api.Request.ProductRequest;
import com.test.productmanager.api.response.ProductResponse;
import com.test.productmanager.entity.ProductEntity;
import com.test.productmanager.repository.ProductRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.BeanUtils;


import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceTest {

    @InjectMocks
    ProductService productService;

    @Mock
    ProductRepository productRepository;

    @Mock
    ObjectMapper objectMapper;

    @Test
    void shouldReturnProductList() {
        ProductEntity productEntityDummy = new ProductEntity();
        productEntityDummy.setName("Test");
        productEntityDummy.setId("asdfg");

        ProductResponse productResponseDummy = new ProductResponse();

        BeanUtils.copyProperties(productEntityDummy, productResponseDummy);

        when(productRepository.findAll()).thenReturn(List.of(productEntityDummy));
        when(objectMapper.convertValue(any(), eq(ProductResponse.class))).thenReturn(productResponseDummy);

        List<ProductResponse> productList = productService.getProductList();

        Assertions.assertEquals(1, productList.size());
        Assertions.assertEquals(productEntityDummy.getId(), productList.get(0).getId());
        verify(productRepository, times(1)).findAll();
    }

    @Test
    void whenReceiveProductRequestShouldCreateProduct() {

        ProductRequest productRequestDummy = new ProductRequest();
        ProductEntity productEntityMock = Mockito.mock(ProductEntity.class);
        productRequestDummy.setName("Test");

        when(objectMapper.convertValue(any(), eq(ProductEntity.class))).thenReturn(productEntityMock);

        productService.createProduct(productRequestDummy);

        verify(productRepository, times(1)).save(any());
    }

    @Test
    void whenReceiveProductRequestNullShouldThrowIllegalArgumentException() {

        ProductRequest productRequestDummy = null;

        when(objectMapper.convertValue(eq(null), eq(ProductEntity.class))).thenThrow(new IllegalArgumentException());

        Assertions.assertThrows(IllegalArgumentException.class,
                () -> productService.createProduct(productRequestDummy));
    }
}
package com.test.productmanager.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductEntity {

    @Id
    private String id;
    private String name;

}

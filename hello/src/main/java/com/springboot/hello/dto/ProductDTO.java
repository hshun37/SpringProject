package com.springboot.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ProductDTO {

    private String name;
    private int price;
    private int stock;

}

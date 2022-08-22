package com.springboot.hello.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponseDTO {

    private Long number;
    private String name;
    private int price;
    private int stock;
}

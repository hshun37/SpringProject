package com.springboot.hello.service;

import com.springboot.hello.dto.ProductDTO;
import com.springboot.hello.dto.ProductResponseDTO;

public interface ProductService {

    ProductResponseDTO get(Long number);

    ProductResponseDTO save(ProductDTO productDTO);

    ProductResponseDTO update(Long number, String name) throws Exception;

    void delete(Long number) throws Exception;

}

package com.springboot.hello.service;

import com.springboot.hello.dao.ProductDAO;
import com.springboot.hello.dto.ProductDTO;
import com.springboot.hello.dto.ProductResponseDTO;
import com.springboot.hello.entity.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductDAO productDAO;

//    @Autowired
//    public ProductServiceImpl(ProductDAO productDAO) {
//        this.productDAO = productDAO;
//    }


    @Override
    public ProductResponseDTO get(Long number) {
        Product product = productDAO.selectProduct(number);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNumber(product.getNumber());
        productResponseDTO.setName(product.getName());
        productResponseDTO.setPrice(product.getPrice());
        productResponseDTO.setStock(product.getStock());

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO save(ProductDTO productDTO) {
        Product product = new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        product.setCreatedAt(LocalDateTime.now());
        product.setUpdatedAt(LocalDateTime.now());

        Product save = productDAO.insertProduct(product);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNumber(save.getNumber());
        productResponseDTO.setName(save.getName());
        productResponseDTO.setPrice(save.getPrice());
        productResponseDTO.setStock(save.getStock());

        return productResponseDTO;
    }

    @Override
    public ProductResponseDTO update(Long number, String name) throws Exception {
        Product updated = productDAO.updateProductName(number, name);

        ProductResponseDTO productResponseDTO = new ProductResponseDTO();
        productResponseDTO.setNumber(updated.getNumber());
        productResponseDTO.setName(updated.getName());
        productResponseDTO.setPrice(updated.getPrice());
        productResponseDTO.setStock(updated.getStock());

        return productResponseDTO;

    }

    @Override
    public void delete(Long number) throws Exception {
        productDAO.deleteProduct(number);
    }
}

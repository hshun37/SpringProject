package com.springboot.hello.dao;

import com.springboot.hello.entity.Product;
import com.springboot.hello.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ProdcutDAOImpl implements ProductDAO{

    private final ProductRepository productRepository;

//    @Autowired
//    public ProdcutDAOImpl(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    @Override
    public Product insertProduct(Product product) {
        Product save = productRepository.save(product);
        return save;
    }

    @Override
    public Product selectProduct(Long number) {
        Product select = productRepository.getReferenceById(number);
        return select;
    }

    @Override
    public Product updateProductName(Long number, String name) throws Exception {
        Optional<Product> select = productRepository.findById(number);

        Product updateProduct;
        if(select.isPresent()) {
            Product product = select.get();

            product.setName(name);
            product.setUpdatedAt(LocalDateTime.now());

            updateProduct = productRepository.save(product);
        } else {
            throw new Exception();
        }

        return updateProduct;

    }

    @Override
    public void deleteProduct(Long number) throws Exception {
        Optional<Product> delete = productRepository.findById(number);

        if (delete.isPresent()) {
            Product product = delete.get();

            productRepository.delete(product);
        } else {
            throw new Exception();
        }

    }
}

package com.springboot.hello.controller;

import com.springboot.hello.dto.ChangeProductNameDTO;
import com.springboot.hello.dto.ProductDTO;
import com.springboot.hello.dto.ProductResponseDTO;
import com.springboot.hello.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

//    @Autowired
//    public ProductController(ProductService productService) {
//        this.productService = productService;
//    }

    @GetMapping()
    public ResponseEntity<ProductResponseDTO> getProduct(Long number) {
        ProductResponseDTO productResponseDTO = productService.get(number);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @PostMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductDTO productDTO) {
        ProductResponseDTO productResponseDTO = productService.save(productDTO);

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @PutMapping()
    public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ChangeProductNameDTO changeProductNameDTO)  throws  Exception{
        ProductResponseDTO productResponseDTO = productService.update(changeProductNameDTO.getNumber(), changeProductNameDTO.getName());

        return ResponseEntity.status(HttpStatus.OK).body(productResponseDTO);
    }

    @DeleteMapping()
    public ResponseEntity<String> deleteProduct(Long number) throws Exception {
        productService.delete(number);

        return ResponseEntity.status(HttpStatus.OK).body("정상적으로 삭제 되었습니다.");
    }

}

package com.codegym.cms.controller;

import com.codegym.cms.model.Product;
import com.codegym.cms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequestMapping(value = "/productRest")
@RestController
public class ProductController {
    @Autowired
    private IProductService productService;


    @GetMapping("/products")
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/productsOrder")
    public ResponseEntity<Page<Product>>  findAllProductByOrder(@PageableDefault(value = 4)Pageable pageable) {
        Page<Product> products = productService.findAllByOrderByNameAsc(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("/products/search")
    public ResponseEntity<Page<Product>> getProductByName(@RequestBody String keyword, Pageable pageable) {
        Page<Product> productList = productService.search(keyword, pageable);
        if (!productList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
    @GetMapping("/productsOrder4")
    public ResponseEntity<Page<Product>>  findAllProductByOrder4(@PageableDefault(value = 4)Pageable pageable) {
        Page<Product> products = productService.findAllByOrderByIdDesc(pageable);
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }


    @PostMapping("/products/create")
    public ResponseEntity saveProduct(@RequestBody Product product) {
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Product> view(@PathVariable Integer id) {
        Optional<Product> product = productService.findById(id);
        if (product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product.get(),HttpStatus.OK);
    }

    @GetMapping("/categories/{id}")
    public ResponseEntity<Page<Product>> getBlogOfCategory(@PathVariable Integer id, Pageable pageable) {
        Page<Product> productList = productService.findByCategoryId(id, pageable);
        if (!productList.hasContent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productList, HttpStatus.OK);
    }
}
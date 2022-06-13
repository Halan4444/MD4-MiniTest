package com.codegym.cms.service.impl;


import com.codegym.cms.model.Product;
import com.codegym.cms.repository.IProductRepository;
import com.codegym.cms.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;

    @Override
    public Iterable<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product);
    }

    @Override
    public void remove(Integer id) {
        productRepository.deleteById(id);
    }
    @Override
    public Page<Product> search(String keyWord, Pageable pageable) {
        return this.productRepository.findAllByNameContaining(keyWord, pageable);
    }
    @Override
    public Page<Product> findByCategoryId(Integer id, Pageable pageable) {
        return this.productRepository.findAllByCategory_Id(id, pageable);
    }

    @Override
    public Page<Product> findAllByOrderByNameAsc(Pageable pageable) {
        return this.productRepository.findAllByOrderByNameAsc(pageable);
    }

    @Override
    public Page<Product> findAllByOrderByIdDesc(Pageable pageable) {
        return this.productRepository.findAllByOrderByIdDesc(pageable);
    }
}

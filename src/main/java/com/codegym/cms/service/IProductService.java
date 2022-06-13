package com.codegym.cms.service;

import com.codegym.cms.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public interface IProductService extends IGeneralService<Product> {
    Page<Product> search(String keyWord, Pageable pageable);

    Page<Product> findByCategoryId(Integer id, Pageable pageable);

    Page<Product> findAllByOrderByNameAsc(Pageable pageable);

    Page<Product> findAllByOrderByIdDesc(Pageable pageable);

}
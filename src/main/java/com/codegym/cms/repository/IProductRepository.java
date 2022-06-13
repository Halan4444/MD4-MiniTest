package com.codegym.cms.repository;

import com.codegym.cms.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product,Integer> {
    Page<Product> findAllByNameContaining(String keyword, Pageable pageable);
    Page<Product> findAllByOrderByIdDesc(Pageable pageable);
    Page<Product> findAllByCategory_Id(Integer id, Pageable pageable);
    Page<Product> findAllByOrderByNameAsc(Pageable pageable);
}

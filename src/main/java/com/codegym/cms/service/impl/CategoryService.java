package com.codegym.cms.service.impl;


import com.codegym.cms.model.Category;
import com.codegym.cms.repository.ICategoryRepository;
import com.codegym.cms.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }


    @Override
    public void remove(Integer id) {
        categoryRepository.deleteById(id);
    }
}

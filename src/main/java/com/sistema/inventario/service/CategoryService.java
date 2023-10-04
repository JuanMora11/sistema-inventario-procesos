package com.sistema.inventario.service;


import com.sistema.inventario.model.Category;
import com.sistema.inventario.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).get();
    }

    public Category updateCategory(Category category, Long id){
        if(categoryRepository.existsById(id)){
            Category categoryBD = categoryRepository.findById(id).get();
            categoryBD.setName(category.getName());
            categoryBD.setDesing(category.getDesing());
            return categoryRepository.save(categoryBD);
        }
        return null;
    }

    public List<Category> findAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }
}

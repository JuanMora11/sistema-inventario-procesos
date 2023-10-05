package com.sistema.inventario.service;
//imports

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

    public Category getCategoryById(Long idCategory){
        return categoryRepository.findById(idCategory).get();
    }

    public Category updateCategory(Category category, Long idCategory){
        if(categoryRepository.existsById(idCategory)){
            Category categoryBD = categoryRepository.findById(idCategory).get();
            categoryBD.setNameCategory(category.getNameCategory());
            return categoryRepository.save(categoryBD);
        }
        return null;
    }

    public List<Category> findAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }
}

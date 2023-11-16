package com.sistema.inventario.service;

import com.sistema.inventario.exceptions.NotFoundException;
import com.sistema.inventario.model.Category;
import com.sistema.inventario.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public Category getCategoryById(Long idCategory){
        Optional<Category> category=categoryRepository.findById(idCategory);
        if (category.isEmpty()){
            throw new NotFoundException("CATEGORY NOT FOUND");
        }
        return category.get();
    }

    public Category createCategory(Category category){
        return categoryRepository.save(category);
    }

    public Category updateCategory(Category category, Long idCategory){
        Optional<Category> categoryBD = categoryRepository.findById(idCategory);
        if (categoryBD.isEmpty()){
            throw new NotFoundException("CATEGORY NOT FOUND");
        }
        categoryBD.get().setNameCategory(category.getNameCategory());
        return categoryRepository.save(categoryBD.get());
    }

    public boolean deleteCategory(Long idCategory){
        Optional<Category> category = categoryRepository.findById(idCategory);
        if (category.isEmpty()){
            throw new NotFoundException("CATEGORY NOT FOUND");
        }
        categoryRepository.delete(category.get());
        return true;
    }


    public List<Category> findAllCategories(){
        return (List<Category>) categoryRepository.findAll();
    }
}

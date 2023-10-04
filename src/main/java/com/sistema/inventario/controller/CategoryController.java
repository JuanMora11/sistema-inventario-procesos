package com.sistema.inventario.controller;

import com.sistema.inventario.model.Category;
import com.sistema.inventario.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("categories")
    public ResponseEntity<Category> create(@RequestBody Category category){
        return new ResponseEntity<>(categoryService.createCategory(category), HttpStatus.CREATED);
    }

    @GetMapping("categories/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id){
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    @PutMapping("categories/{id}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long id){
        return ResponseEntity .ok(categoryService.updateCategory(category,id));
    }

    @GetMapping("categories")
    public ResponseEntity<List<Category>> getAll(){
        return ResponseEntity.ok(categoryService.findAllCategories());
    }
}

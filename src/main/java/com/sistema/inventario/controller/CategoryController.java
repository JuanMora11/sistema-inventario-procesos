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

    @GetMapping("category/{idCategory}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long idCategory){
        return ResponseEntity.ok(categoryService.getCategoryById(idCategory));
    }

    @PutMapping("categories/{idCategory}")
    public ResponseEntity<Category> update(@RequestBody Category category, @PathVariable Long idCategory){
        return ResponseEntity .ok(categoryService.updateCategory(category,idCategory));
    }

    @DeleteMapping("category/{idCategory}")
    public ResponseEntity<String> delete(@PathVariable Long idCategory){
        return new ResponseEntity(categoryService.deleteCategory(idCategory), HttpStatus.NO_CONTENT);
    }

    @GetMapping("categories")
    public ResponseEntity<List<Category>> getAll()
    {
        return ResponseEntity.ok(categoryService.findAllCategories());
    }
}

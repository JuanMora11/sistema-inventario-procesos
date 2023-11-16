package com.sistema.inventario.controller;

import com.sistema.inventario.model.Article;
import com.sistema.inventario.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticleController {
    @Autowired
    private ArticleService articleService;
    @PostMapping("articles/{idCategory}")
    public ResponseEntity<Article> create(@RequestBody Article article, @PathVariable Long idCategory){
        return new ResponseEntity(articleService.createArticle(article, idCategory), HttpStatus.CREATED);
    }
    @GetMapping("article/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable Long id){
        return ResponseEntity.ok(articleService.getArticleById(id));
    }
    @PutMapping("article/{id}")
    public ResponseEntity<Article> update(@RequestBody Article article, @PathVariable Long id){
        return ResponseEntity.ok(articleService.updateArticle(article, id));
    }
    @GetMapping("articles")
    public ResponseEntity<List<Article>> getAll(){
        return ResponseEntity.ok(articleService.findAllArticles());
    }

    @DeleteMapping("article/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id){
        return new ResponseEntity(articleService.deleteArticle(id), HttpStatus.NO_CONTENT);
    }
}

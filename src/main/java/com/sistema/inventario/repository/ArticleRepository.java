//hello
package com.sistema.inventario.repository;

import com.sistema.inventario.model.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    List<Article> findByName(String name);
}
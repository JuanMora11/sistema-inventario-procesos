//hello
package com.sistema.inventario.repository;

import com.sistema.inventario.model.Article;
import org.springframework.data.repository.CrudRepository;

public interface ArticleRepository extends CrudRepository<Article, Long> {

}
//hello
package com.sistema.inventario.service;

import com.sistema.inventario.exceptions.NotFoundException;
import com.sistema.inventario.model.Article;
import com.sistema.inventario.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {
    @Autowired
    private ArticleRepository  articleRepository;
    public Article createArticle(Article article){
        return articleRepository.save(article);
    }
    public Article getArticleById(Long id){
        if (id == 0){
            throw new NotFoundException("Article id is null");
        }
        Optional<Article> article = articleRepository.findById(id);
        if (article.isEmpty()){
            throw new NotFoundException("Article not found");
        }
        return article.get();
    }
    public Article updateArticle(Article article, Long id){
        if (articleRepository.existsById(id)){
            Article articleBd = articleRepository.findById(id).get();
            articleBd.setName(article.getName());
            articleBd.setPrice(article.getPrice());
            articleBd.setDescription(article.getDescription());
            articleBd.setColor(article.getColor());
            articleBd.setMaterial(article.getMaterial());
            articleBd.setQuantity(article.getQuantity());
            articleBd.setCategory(article.getCategory());
            return articleRepository.save(articleBd);
        }
        return null;
    }
    public List<Article> findAllArticles(){
        return (List<Article>)articleRepository.findAll();
    }
}

package com.dubu.party.domain.user.service;


import com.dubu.party.common.exception.ArticleNotFoundException;
import com.dubu.party.domain.user.db.entity.Article;
import com.dubu.party.domain.user.db.entity.User;
import com.dubu.party.domain.user.db.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    public List<Article> getAllArticle() {
        return articleRepository.findAll();
    }

    public Article getArticleById(Long id){
        return articleRepository.findById(id)
                .orElseThrow(()->new ArticleNotFoundException(id));
    }

    public List<Article> getArticlesByUser(User user) {
        return articleRepository.findByUser(user);
    }

    public Article createArticle(String title, String content, User user) {
        Article article = new Article();

        article.setUser(user);
        article.setTitle(title);
        article.setContent(content);

        return articleRepository.save(article);
    }

    public Article updateArticle(Long id,String title,String content) {
        Article article = getArticleById(id);
        article.setTitle(title);
        article.setContent(content);
        return articleRepository.save(article);
    }

    public void deleteArticle(Long id){
        articleRepository.deleteById(id);
    }

}

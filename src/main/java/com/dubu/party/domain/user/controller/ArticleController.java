package com.dubu.party.domain.user.controller;

import com.dubu.party.domain.user.db.entity.Article;
import com.dubu.party.domain.user.db.entity.User;
import com.dubu.party.domain.user.request.ArticleRequest;
import com.dubu.party.domain.user.service.ArticleService;
import com.dubu.party.domain.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    public ArticleService articleService;

    @Autowired
    public UserService userService;


    @GetMapping("/all")
    public ResponseEntity<?> getAllArticles() {
        List<Article> articles = articleService.getAllArticle();
        return ResponseEntity.ok(articles);
    }

    @GetMapping(params = "user")// /articles?user=5
    public ResponseEntity<List<Article>> getArticlesByUser(@RequestParam("user") Long userId) {
        User user = userService.getUserById(userId);
        List<Article> articles = articleService.getArticlesByUser(user);
        System.out.println(articles.toString());
        return ResponseEntity.ok(articles);
    }

    @PostMapping
    public ResponseEntity<?> createArticle(@RequestBody ArticleRequest articleRequest) {

        User user = userService.getUserById(articleRequest.getUserId());
        Article article = articleService.createArticle(
                articleRequest.getTitle(),
                articleRequest.getContent(),
                user
        );

        return ResponseEntity.ok("article 생성 성공");

    }




    @GetMapping("/{id}")
    public ResponseEntity<Article> getArticleById(@PathVariable("id") Long id) {
        Article article = articleService.getArticleById(id);
        return ResponseEntity.ok(article);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Article> updateArticle(@PathVariable("id") Long id, @RequestBody ArticleRequest articleRequest) {
        Article newArticle = articleService.updateArticle(id,articleRequest.getTitle(), articleRequest.getContent());
        return ResponseEntity.ok(newArticle);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArticle(@PathVariable("id") Long id) {
        articleService.deleteArticle(id);
        return ResponseEntity.noContent().build(); // 204 No content
    }
}

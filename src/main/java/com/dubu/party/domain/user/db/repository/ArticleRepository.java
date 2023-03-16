package com.dubu.party.domain.user.db.repository;

import com.dubu.party.domain.user.db.entity.Article;
import com.dubu.party.domain.user.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long>  {
    List<Article> findByUser(User user);
    // findByUser() 메소드를 선언하여 해당 작성자에 대한 Article 목록을 반환
}

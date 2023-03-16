package com.dubu.party.domain.user.request;


import lombok.Getter;
import lombok.Setter;

@Getter
public class ArticleRequest {
    private String title;
    private String content;

    private Long userId;

}

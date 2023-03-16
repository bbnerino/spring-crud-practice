package com.dubu.party.domain.user.db.entity;
import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="articles")
@Getter @Setter
public class Article {
    @Id @GeneratedValue
    private Long id;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id",nullable = false)
    @JsonIgnoreProperties("articles")
    User user;

}

package com.dubu.party.domain.user.db.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 롬복 getter


@Entity // JPA(Java Persistence API)를 사용하여 객체와 데이터베이스 테이블 간의 매핑을 정의
@ApiModel(value = "User", description = "회원 정보") // swagger
@NoArgsConstructor(access = AccessLevel.PROTECTED) // 롬복 생성자 : 기본 생성자를 자동으로 생성
@AllArgsConstructor(access = AccessLevel.PRIVATE) // 모든 필드를 파라미터로 갖는 생성자를 간편하게 생성
@Builder // 롬복 : Builder 패턴을 구현
// ex) MyClass.builder().id(1).name("John")

public class User {
    @ApiModelProperty(value = "회원 id") // 스웨거
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 회원 id
    Long userId;

    @ApiModelProperty(value="회원 닉네임")
    String userNick;

    @ApiModelProperty(value = "회원 이메일")
    String userEmail;


    @ApiModelProperty(value ="회원 이름")
    String userName;

    @ApiModelProperty(value = "회원 메모")
    String userMemo;

    // 프로필 이미지 url
    @ApiModelProperty(value = "회원 프로필 이미지 url")
    String userImgUrl;

}

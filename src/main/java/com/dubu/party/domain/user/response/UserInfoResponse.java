package com.dubu.party.domain.user.response;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Getter
@Builder
@ApiModel("UserInfoResponse")
public class UserInfoResponse {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 회원 id
    Long userId;

    @ApiModelProperty(value="회원 닉네임")
    String userNick;

    @ApiModelProperty(value = "회원 이메일")
    String userEmail;

    @ApiModelProperty(value = "회원 메모")
    String userMemo;

    @ApiModelProperty(value = "회원 프로필 이미지 url")
    String userImgUrl;

    // 팔로워 수
    @ApiModelProperty(value="나를 팔로우하는 사람 수")
    Long followerCnt;

    // 팔로잉수
    @ApiModelProperty(value="내가 팔로우 하는 사람 수")
    Long followeeCnt;
}

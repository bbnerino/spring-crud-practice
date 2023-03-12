package com.dubu.party.domain.user.response;

import com.dubu.party.domain.user.db.entity.User;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@ApiModel("UserAllResponse")
public class UserAllResponse {
    @ApiModelProperty(value = "유저")
    User user;

//    @ApiModelProperty(value = "팔로워")
//    List<Follow> follower;

//    @ApiModelProperty(value = "팔로이")
//    List<Follow> followee;

}

package com.dubu.party.domain.user.service;

import com.dubu.party.domain.user.db.entity.User;
import com.dubu.party.domain.user.request.UserUpdateRequest;
import com.dubu.party.domain.user.response.UserAllResponse;
import com.dubu.party.domain.user.response.UserInfoResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.io.IOException;
import java.util.List;

public interface UserService {
    User getUserByEmail(String userEmail);

    Long userUpdateWithProfileImg(UserUpdateRequest userInfo, String userEmail) throws IOException;
    UserInfoResponse getUserInfo(User user);
    List<User> searchUser(String userNick);
    Page<User> getUserList(Pageable pageable);
    List<UserAllResponse> getUserAll();
}

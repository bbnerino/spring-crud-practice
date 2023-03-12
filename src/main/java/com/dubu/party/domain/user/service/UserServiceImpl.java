package com.dubu.party.domain.user.service;
import com.dubu.party.domain.user.db.entity.User;
import com.dubu.party.domain.user.db.repository.UserRepository;
import com.dubu.party.domain.user.db.repository.UserRepositorySupport;
import com.dubu.party.domain.user.request.UserUpdateRequest;
import com.dubu.party.domain.user.response.UserAllResponse;
import com.dubu.party.domain.user.response.UserInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;


/**
 * 유저 관련 비즈니스 로직 처리를 위한 서비스 구현 정의.
 */
@Service("userService")
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Autowired
    UserRepositorySupport userRepositorySupport;

    @Override
    public User getUserByEmail(String userEmail) {
        // DB 유저 정보 조회 (Email 를 통한 조회).
        User user = userRepositorySupport.findByEmail(userEmail).orElse(null);
        System.out.println(user); // 추가
        return user;
    }

    @Override
    public Long userUpdateWithProfileImg(UserUpdateRequest userInfo, String userEmail) throws IOException {
        return null;
    }

    @Override
    public UserInfoResponse getUserInfo(User user) {
        return null;
    }

    @Override
    public List<User> searchUser(String userNick) {
        return null;
    }

    @Override
    public Page<User> getUserList(Pageable pageable) {
        return null;
    }

    @Override
    public List<UserAllResponse> getUserAll() {
        return null;
    }
}

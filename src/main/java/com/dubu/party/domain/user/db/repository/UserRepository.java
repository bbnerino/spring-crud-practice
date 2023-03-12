package com.dubu.party.domain.user.db.repository;

import com.dubu.party.domain.user.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


//디비 쿼리 생성을 위한 JPA Query Method 인터페이스 정의.
// JPARepository 를 사용하기 위해 Spring Data JPA와 JDBC 드라이버를 추가
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // 아래와 같이, Query Method 인터페이스(반환값, 메소드명, 인자) 정의를 하면 자동으로 Query Method 구현됨.
    Optional<User> findUserById(Long userId);
    Optional<User> findUserByNick(String userNick);
    Optional<User> findUserByEmail(String userEmail);
}

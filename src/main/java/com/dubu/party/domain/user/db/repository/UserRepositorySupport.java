package com.dubu.party.domain.user.db.repository;


import com.dubu.party.domain.user.db.entity.User;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * 유저 모델 관련 디비 쿼리 생성을 위한 구현 정의.
 */


@RequiredArgsConstructor //클래스의 필드들을 초기화하는 생성자를 자동으로 생성
@Repository
// @Transactional 어노테이션을 사용하려면,
// 해당 클래스에 @EnableTransactionManagement 어노테이션을 추가해야 합니다
@Transactional
public class UserRepositorySupport {
    @Autowired
    // JPAQueryFactory : Querydsl 라이브러리를 사용하여 JPA 쿼리를 더 쉽게 작성
    private JPAQueryFactory jpaQueryFactory;
//    QUser qUser = QUser.user;
//    QDeal qDeal = QDeal.deal;

    public Optional<User> findByEmail(String userEmail) {
        // Querydsl
        // JPQL과 Querydsl에서 동일한 작업(특정 회원 1명 조회)를 하는 코드이다.
        // 두 개의 큰 차이점으로 쿼리 문법 오류를 JPQL은 실행 시점에 발견할 수 있으며, Querydsl은 컴파일 시점에 발견 가능
//        User user = jpaQueryFactory.select(qUser).from(qUser)   // 2차 오류 원인 가능
//                .where(qUser.userEmail.eq(userEmail)).fetchOne(); // fetchOne() : 단건 조회시 사용
//
//        if (null == user) return Optional.empty(); // user 비어있음
//        return Optional.ofNullable(user); // 비어있지 않음

    }
}

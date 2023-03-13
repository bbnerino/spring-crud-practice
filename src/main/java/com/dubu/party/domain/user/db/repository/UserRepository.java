package com.dubu.party.domain.user.db.repository;

import com.dubu.party.domain.user.db.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;



// DB 와 연결해 CRUD 작업을 수행한다.
public interface UserRepository extends JpaRepository<User, Long> {

}

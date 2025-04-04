package com.build.playerconnectbeta.repository;

import com.build.playerconnectbeta.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByEmail(String email);
}

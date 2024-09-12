package com.improvement.dslearn.repositories;

import com.improvement.dslearn.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "SELECT * FROM tb_user WHERE email = :email", nativeQuery = true)
    Optional<User> findByEmail(String email);
}

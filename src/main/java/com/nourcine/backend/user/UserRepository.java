package com.nourcine.backend.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);



    boolean existsByEmail(String email);
    List<User> findByRole(Role role);
}

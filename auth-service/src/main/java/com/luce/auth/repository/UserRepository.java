package com.luce.auth.repository;

import com.luce.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Futuramente, poderíamos adicionar métodos como:
    // Optional<User> findByUsername(String username);
}
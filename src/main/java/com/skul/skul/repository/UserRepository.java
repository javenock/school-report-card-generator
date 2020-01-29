package com.skul.skul.repository;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

import com.skul.skul.model.User;

public interface UserRepository extends JpaRepository<User, Integer>
{
    Optional<User> findByEmail(String email);
}


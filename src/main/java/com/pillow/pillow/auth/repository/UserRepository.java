package com.pillow.pillow.auth.repository;

import com.pillow.pillow.auth.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID>{

    boolean existsByEmail(String email);

    Optional<UserModel> findByEmail(String email);
}

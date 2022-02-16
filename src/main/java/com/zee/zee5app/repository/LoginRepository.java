package com.zee.zee5app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zee.zee5app.dto.Login;

public interface LoginRepository extends JpaRepository<Login, String> {
  Boolean existsByUserName(String userName);
}

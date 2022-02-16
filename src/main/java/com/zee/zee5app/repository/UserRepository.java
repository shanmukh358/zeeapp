package com.zee.zee5app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.zee.zee5app.dto.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	//custom jpa method:we will not write any def just only declaration
	Boolean existsByEmailAndFirstname(String email,String firstname);
	Optional<User> findByUsername(String username);
	Boolean existsByUsername(String username);
	
	Boolean existsByEmail(String email);
}

package com.todaktodak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
	
	@Query(value = "select * from tb_user where user_email = :email", nativeQuery = true)
	public User getNick(@Param("email") String email);
}
package com.todaktodak.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.todaktodak.entity.User;

@Repository
public interface MypageRepository extends JpaRepository<User, Long> {
	
	@Query(value = "UPDATE tb_user SET user_nick = :nick WHERE user_email = :email", nativeQuery = true)
	public String change(@Param("email") String email, @Param("nick") String nick);
	
}

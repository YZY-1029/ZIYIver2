package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// 取得使用者帳號
	@Query(value = "select user_email from user where user_id = :userId", nativeQuery = true)
	String getUserEmail(String userId);

	
	// 取得使用者名字
	@Query(value = "select user_name from user where user_id = :userId ",nativeQuery = true)
	String getUserName(String userId);


	// 取得使用者密碼
	@Query(value = "select user_password from user where user_password = :userPassword", nativeQuery = true)
	String getUserPassword(String userId);

}

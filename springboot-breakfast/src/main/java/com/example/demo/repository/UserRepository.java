package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	// 取得使用者所有資訊
	@Query(value = "select * from user where user_email = :email", nativeQuery = true)
	User findByUserEmail(@Param("userEmail") String email);
	
	// 取得使用者帳號
	@Query(value = "select user_email from user where user_id = :userId", nativeQuery = true)
	String getUserEmail(@Param("userId") Integer userId);

	
	// 取得使用者名字
	@Query(value = "select user_name from user where user_id = :userId ",nativeQuery = true)
	String getUserName(@Param("userId") Integer userId);


	// 取得使用者加鹽過後的密碼
	@Query(value = "select user_password from user where user_id = :userId ", nativeQuery = true)
	String getUserPassword(@Param("userId") Integer userId);

}

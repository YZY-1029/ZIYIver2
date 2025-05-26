package com.example.demo.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Biography;

@Repository
public interface BiographyRepository extends JpaRepository<Biography, Integer> {

	@Query("select b from Biography b inner join fetch b.author") // 內連

	/*
	 * A 1
	 * B 2
	 * C 4
	 * 
	 */
	
	//@Query("select b from Biography b left join b.author") // 諾沒有查到 Author 則該欄位顯示 null
	
	/*
	 * A 1
	 * B 2
	 * C null
	 * D 4 
	 */
	
	List<Biography> findAllWithAuthor();
	
	
}

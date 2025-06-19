package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.OrderTable;
import com.example.demo.model.entity.User;

@Repository
public interface OrderTableRepository extends JpaRepository<OrderTable, Integer>  {
	List<OrderTable> findByUser(User user);
}

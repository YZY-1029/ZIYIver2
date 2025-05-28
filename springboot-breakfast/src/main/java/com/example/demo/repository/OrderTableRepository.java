package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.OrderTable;

@Repository
public interface OrderTableRepository extends JpaRepository<OrderTable, Integer>  {

}

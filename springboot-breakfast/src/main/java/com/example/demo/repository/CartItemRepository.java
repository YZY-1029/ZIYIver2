package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.entity.Cart;
import com.example.demo.model.entity.CartItem;
import com.example.demo.model.entity.User;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Integer> {

}

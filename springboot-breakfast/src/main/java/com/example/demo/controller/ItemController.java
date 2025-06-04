package com.example.demo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.entity.Item;
import com.example.demo.repository.ItemRepository;

@RestController
@RequestMapping("api/item")
@CrossOrigin(origins = "http://localhost:5173")
public class ItemController {

	@Autowired
	private ItemRepository itemRepository;
	
	@GetMapping
	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable Integer id) {
		return itemRepository.findById(id)
							 .map(item -> ResponseEntity.ok(item))
							 .orElse(ResponseEntity.notFound().build());
	}
}

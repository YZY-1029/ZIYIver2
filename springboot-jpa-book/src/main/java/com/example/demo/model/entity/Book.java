package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Data
@Entity
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 100, nullable = false)
	private String name;
	
	@ManyToMany(mappedBy = "books")
	private List<Publisher> publishers;
	
	
	@ManyToOne // 也可以改成 @ManyToOne(fetch = FetchType.LAZY) 讓搜尋時不會有作者這藍
	@JoinColumn(name = "author_id")
	private Author author;
	
	
}
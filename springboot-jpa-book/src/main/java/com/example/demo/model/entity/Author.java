package com.example.demo.model.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Data
@Entity
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String name;
	
	
	@OneToOne(mappedBy = "author")
	private Biography biography;
	
	
	
	@OneToMany(mappedBy = "author")  // 只查作者
//	@OneToMany(mappedBy = "author", fetch = FetchType.EAGER) // 這裡如果只查名字的話她會連輸也幫你查 // 查作者 + 書籍
	private List<Book> books;
	
}

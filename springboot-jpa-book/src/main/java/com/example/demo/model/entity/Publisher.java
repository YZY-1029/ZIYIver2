package com.example.demo.model.entity;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Data
@Entity
public class Publisher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(length = 50, nullable = false)
	private String Name;
	
	@ManyToMany
	@JoinTable(
			name = "publisher_book",
			joinColumns = @JoinColumn(name = "Publisher_id"),
			inverseJoinColumns = @JoinColumn(name = "book_id")
	)
	private List<Book> books;
	
	// 自薦一個新增書籍ㄉ方法
	public void addBook(Book book) {
		if(books == null ) {
			books = new CopyOnWriteArrayList<>();
		}
		books.add(book);
	}
	
	// 自薦一個移除書籍ㄉ方法
	public void removeBook(Book book) {
		if(books == null ) {
			return;
		}
		books.remove(book);
	
	}
	
	
}

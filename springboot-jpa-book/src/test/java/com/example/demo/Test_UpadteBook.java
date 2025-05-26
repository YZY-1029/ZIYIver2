package com.example.demo;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Author;
import com.example.demo.model.entity.Book;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;
//
@SpringBootTest
public class Test_UpadteBook {
	
	@Autowired
	private AuthorRepository authorReposity;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private void updateBookName() {
		Optional<Author> optAuthor = authorReposity.findById(2);
		if(optAuthor.isEmpty()) {
			System.out.println("查無此書");
			return;
		}
		
		Optional<Book> optBook = bookRepository.findById(1);
		if(optBook.isEmpty()) {
			System.out.println("查無此書");
			return;
		}
		
		Author author = optAuthor.get();
		Book book = optBook.get();
		
		// 更新設定
		book.setAuthor(author);
		
		// 儲存更新
		bookRepository.save(book);
		
		
	}
	
}

package com.example.demo;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.entity.Author;
import com.example.demo.repository.AuthorRepository;
import com.example.demo.repository.BookRepository;

import jakarta.persistence.FetchType;
import jakarta.transaction.Transactional;

@SpringBootTest
public class Test_ReadAuthor {

	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	
	@Test
	// (第二種解決方案) @Transactional 如果要查1000個作者ㄉ時候就會下1000個 SQL  (第三種解決方法在 AuthorRepository )
	public void read() {
		// 查詢作者
		List<Author> authors = authorRepository.findAll();
		authors.forEach(author -> {
			System.out.printf("ID:%d Name:%s%n",author.getId(), author.getName());
		});
		
		// 查詢作者 + 書籍
// 因為下面是一對多 所以會延遲抓取 且在預設ㄉ時候是不會幫你抓  所以要在AUTHOR那邊 fetch = FetchType.EAGER 加入此
		List<Author> author2 = authorRepository.findAllWithBook();
		author2.forEach(author -> {
			System.out.printf("ID:%d Name:%s%n  著作數量:%d%n",author.getId(), author.getName(), author.getBooks().size());
		});
		
		
		
	}
	
}

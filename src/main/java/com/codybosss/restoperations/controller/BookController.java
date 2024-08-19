package com.codybosss.restoperations.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codybosss.restoperations.entity.Book;
import com.codybosss.restoperations.service.BookService;

@RestController
@RequestMapping("/api/book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	//create
	@PostMapping
	public Book createBook(@RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	//read
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Book> getBooksById(@PathVariable Long id){
		Optional<Book> book = bookService.getBookById(id);		
		return book.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
	}
	
	//update
	@PutMapping("/{id}")
	public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book bookDetails){
		Optional<Book> book = bookService.getBookById(id);
		if(book.isPresent()) {
			Book updateBook = book.get();
			updateBook.setTitle(bookDetails.getTitle());
			updateBook.setAuther(bookDetails.getAuther());
			return ResponseEntity.ok(bookService.updateBook(updateBook));
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	//delete
	@DeleteMapping("/{id}")
	public ResponseEntity<Book> deleteBook(@PathVariable Long id){
		bookService.deleteBook(id);
		return ResponseEntity.ok().build();
		
	}
}

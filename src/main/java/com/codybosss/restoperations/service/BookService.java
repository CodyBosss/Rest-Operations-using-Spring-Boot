package com.codybosss.restoperations.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codybosss.restoperations.entity.Book;
import com.codybosss.restoperations.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	//create
	public Book saveBook(Book book) {
		return bookRepository.save(book);
	}

	//read
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookById(Long id){
		return bookRepository.findById(id);
	}
	
	//update
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	//delete
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);
	}
}

package com.codybosss.restoperations.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codybosss.restoperations.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long>{

}

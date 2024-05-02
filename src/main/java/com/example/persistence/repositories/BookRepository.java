package com.example.persistence.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.persistence.models.Book;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	List<Book> findByTitle(String title);	
}

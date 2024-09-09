package com.library.LibraryManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.LibraryManagementSystem.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long>{
	
	List<Book> findByTitle(String title);

}

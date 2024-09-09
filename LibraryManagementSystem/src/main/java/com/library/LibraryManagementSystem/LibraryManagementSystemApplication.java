package com.library.LibraryManagementSystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.library.LibraryManagementSystem.Model.Book;
import com.library.LibraryManagementSystem.Model.Customer;
import com.library.LibraryManagementSystem.Model.Transaction;
import com.library.LibraryManagementSystem.Repository.BookRepository;
import com.library.LibraryManagementSystem.Repository.CustomerRepository;
import com.library.LibraryManagementSystem.Repository.TransactionRepository;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(LibraryManagementSystemApplication.class, args);
		
		}

}

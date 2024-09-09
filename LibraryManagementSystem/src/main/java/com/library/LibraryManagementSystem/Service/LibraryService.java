package com.library.LibraryManagementSystem.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.TransientDataAccessResourceException;
import org.springframework.stereotype.Service;

import com.library.LibraryManagementSystem.Model.Book;
import com.library.LibraryManagementSystem.Model.Customer;
import com.library.LibraryManagementSystem.Model.Transaction;
//import com.library.LibraryManagementSystem.Model.User;
import com.library.LibraryManagementSystem.Repository.BookRepository;
import com.library.LibraryManagementSystem.Repository.CustomerRepository;
import com.library.LibraryManagementSystem.Repository.TransactionRepository;
//import com.library.LibraryManagementSystem.Repository.UserRepository;

@Service
public class LibraryService {
	
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public List<Book> getAllBooks(){
		return bookRepository.findAll();
	}
	
	
	public List<Book> searchBooks(String title) {
        return bookRepository.findByTitle(title);
    }
	
	public void issueBook(Long bookId,Long userID) {
		Book book = bookRepository.findById(bookId).orElseThrow(()->new RuntimeException("Book not found"));
		Customer customer = customerRepository.findById(userID).orElseThrow(()->new RuntimeException("User not found"));
		
		if(!book.isAvailable()) {
			throw new IllegalStateException("Book is available");
		}
		
		Transaction transaction = new Transaction();
		transaction.setBook(book);
		transaction.setCustomer(customer);
		transaction.setIssueDate(LocalDate.now());

        book.setAvailable(false);
        transactionRepository.save(transaction);
        bookRepository.save(book);
		
	}
	
	
	public void returnBook(Long transactionId) {
		Transaction transaction = transactionRepository.findById(transactionId).orElseThrow(() -> new RuntimeException("Transaction not found"));
        transaction.setReturnDate(LocalDate.now());

        Book book = transaction.getBook();
        book.setAvailable(true);

        transactionRepository.save(transaction);
        bookRepository.save(book);
	}
	
	

} 

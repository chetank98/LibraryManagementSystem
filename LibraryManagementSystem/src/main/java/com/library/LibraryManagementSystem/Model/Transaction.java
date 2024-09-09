package com.library.LibraryManagementSystem.Model;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Transaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long transactionId;
	
	@ManyToOne
	@JoinColumn(name="customer_id",nullable = false)
	private Customer customer;
	
	@ManyToOne
	@JoinColumn(name="book_id", nullable = false)
	private Book book;
	
	private LocalDate issueDate;
	private LocalDate returnDate;
	
	public Transaction() {
		
	}

	public Transaction(Customer customer, Book book, LocalDate issueDate, LocalDate returnDate) {
		super();
		this.customer = customer;
		this.book = book;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
	}

	public Long getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(Long transactionId) {
		this.transactionId = transactionId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	public LocalDate getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}

	

	

	
	
	

}

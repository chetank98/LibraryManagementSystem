package com.library.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.LibraryManagementSystem.Model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long>{

}

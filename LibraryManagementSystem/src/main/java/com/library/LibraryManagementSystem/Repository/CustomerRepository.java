package com.library.LibraryManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.library.LibraryManagementSystem.Model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

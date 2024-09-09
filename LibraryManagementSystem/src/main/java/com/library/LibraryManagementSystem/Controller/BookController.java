package com.library.LibraryManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.library.LibraryManagementSystem.Service.LibraryService;
import com.library.LibraryManagementSystem.Model.Book;

@RestController
@RequestMapping("/api/books")
public class BookController {
	
	@Autowired
	public LibraryService libraryService;
	

    @GetMapping("/getlist")
    public List<Book> getBooks() {
        return libraryService.getAllBooks();
    }

    @GetMapping("/search")
    public List<Book> searchBooks(@RequestParam String title) {
        return libraryService.searchBooks(title);
    }

    @PostMapping("/issue")
    public ResponseEntity<String> issueBook(@RequestParam Long bookId, @RequestParam Long customerId) {
        libraryService.issueBook(bookId, customerId);
        return ResponseEntity.ok("Book issued successfully.");
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnBook(@RequestParam Long transactionId) {
        libraryService.returnBook(transactionId);
        return ResponseEntity.ok("Book returned successfully.");
    }

}

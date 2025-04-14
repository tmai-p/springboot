package com.mongodb.controller;

import com.mongodb.model.Books;
import com.mongodb.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mongodb")
public class BooksController {

    @Autowired
    private BookRepo bookRepo;

    @GetMapping("/all_books")
    public ResponseEntity<List<Books>> getAllBooks() {
        List<Books> booklist = bookRepo.findAll();
        return new ResponseEntity<>(booklist, HttpStatus.OK);
    }

    @GetMapping("/by_author")
    public ResponseEntity<List<Books>> getBookByAuthor(@RequestParam String author) {
        List<Books> booklist = bookRepo.findBookByAuthor(author);
        return new ResponseEntity<>(booklist, HttpStatus.OK);
    }

    @PostMapping("/add_book")
    public ResponseEntity<String> addABook(@RequestBody Books book) {
        bookRepo.insert(book);
        return new ResponseEntity<>("Successfully added", HttpStatus.OK);
    }

    @PutMapping("/update_book")
    public ResponseEntity<String> getBookByAuthor(@RequestBody Books book) {
        bookRepo.save(book);
        return new ResponseEntity<>("Successfully updated", HttpStatus.OK);
    }

    @DeleteMapping("/delete_book")
    public ResponseEntity<String> deleteBookById(@RequestParam String id){
        bookRepo.deleteById(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}

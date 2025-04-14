package com.example.springbatch.controller;

import com.example.springbatch.model.Books;
import com.example.springbatch.model.Users;
import com.example.springbatch.repo.BooksRepository;
import com.example.springbatch.repo.UsersRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BatchController {

    private final UsersRepository usersRepository;
    private final BooksRepository booksRepository;

    public BatchController(UsersRepository usersRepository, BooksRepository booksRepository) {
        this.usersRepository = usersRepository;
        this.booksRepository = booksRepository;
    }

    @GetMapping("/api/users")
    public ResponseEntity<List<Users>> displayUser() {

        List<Users> users = usersRepository.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/api/books")
    public ResponseEntity<List<Books>> displayBooks() {

        List<Books> books = booksRepository.findAll();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
}

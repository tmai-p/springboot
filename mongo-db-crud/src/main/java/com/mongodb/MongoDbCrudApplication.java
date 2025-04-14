package com.mongodb;

import com.mongodb.model.Books;
import com.mongodb.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
//public class MongoDbCrudApplication implements CommandLineRunner {
public class MongoDbCrudApplication {

	@Autowired
	BookRepo bookRepo;

	public static void main(String[] args) {
		SpringApplication.run(MongoDbCrudApplication.class, args);
	}

	/*
	@Override
	public void run(String... args) throws Exception {
		showAllBooks();
		getBookByAuthor("Chris Claremont");
		getBookCount();
		System.out.println("------------------------------------");
		System.exit(0);
	}

	public void showAllBooks() {
		System.out.println("------- ALL BOOKS ------------------");
		List<Books> itemList = bookRepo.findAll();
		itemList.forEach(item -> System.out.println(
				"id: " +item.getId() + "\t" +
				"title: " +item.getTitle() + "\t" +
				"author: " +item.getAuthor()));
	}
	public void getBookByAuthor(String auth) {
		System.out.println("------- BOOK BY AUTHOR ------------------");
		List<Books> books = bookRepo.findBookByAuthor(auth);
		books.forEach(book -> System.out.println(
				"Title: " + book.getTitle() +
				", Author: " + book.getAuthor() +
				", Rating: " + book.getRating()
		));
	}
	public void getBookCount() {
		System.out.println("------- BOOK COUNTS ------------------");
		System.out.println(bookRepo.count());
	}
	*/
}

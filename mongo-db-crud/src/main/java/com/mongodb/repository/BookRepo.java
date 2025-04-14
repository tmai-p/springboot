package com.mongodb.repository;

import com.mongodb.model.Books;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface BookRepo extends MongoRepository<Books,String> {
    @Query("{author:'?0'}")
    List<Books> findBookByAuthor(String author);

    @Query(value="{title:'?0'}", fields="{'rating' : 1, 'pages' : 1}")
    List<Books> findAll(String title);

    public long count();
}

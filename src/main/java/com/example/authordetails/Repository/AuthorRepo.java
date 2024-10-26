package com.example.authordetails.Repository;

import com.example.authordetails.Entity.Author;
import org.springframework.data.mongodb.repository.MongoRepository;



public interface AuthorRepo extends MongoRepository<Author,Integer> {
    Author findByBookAuthorId(String bookAuthorId);

}

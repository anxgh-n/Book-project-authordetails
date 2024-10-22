package com.example.authordetails.Repository;

import com.example.authordetails.Entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepo extends JpaRepository<Author,Integer> {
    Author findByBookAuthorId(String bookAuthorId);
}

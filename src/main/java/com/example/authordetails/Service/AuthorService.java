package com.example.authordetails.Service;

import com.example.authordetails.Entity.Author;
import com.example.authordetails.Repository.AuthorRepo;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class AuthorService {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Author addAuthor(Author author){
        return authorRepo.save(author);
    }

    public Author getAuthorById(String bookAuthorId){
        return authorRepo.findByBookAuthorId(bookAuthorId);
    }

}

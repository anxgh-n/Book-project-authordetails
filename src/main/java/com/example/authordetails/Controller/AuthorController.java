package com.example.authordetails.Controller;

import com.example.authordetails.Dto.Authordto;
import com.example.authordetails.Entity.Author;

import com.example.authordetails.Service.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/author")
public class AuthorController {

    @Autowired
    private AuthorServiceImpl authorService;

    @PostMapping("/addauthor")
    public ResponseEntity<Author> addAuthor(@RequestBody Author author){
        return ResponseEntity.ok(authorService.addAuthor(author));
    }

    @GetMapping("/getauthor/{bookAuthorId}")
    public Mono<ResponseEntity<Authordto>> getAuthorByBookAuthorId(@PathVariable("bookAuthorId") String bookAuthorId){
        return authorService.getAuthorByBookAuthorId(bookAuthorId)
                .map(ResponseEntity::ok);
    }
}

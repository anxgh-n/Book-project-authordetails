package com.example.authordetails.Service;

import com.example.authordetails.Dto.Authordto;
import com.example.authordetails.Dto.Bookdto;
import com.example.authordetails.Entity.Author;
import com.example.authordetails.Repository.AuthorRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class AuthorServiceImpl {

    @Autowired
    private AuthorRepo authorRepo;

    @Autowired
    private WebClient.Builder webClientBuilder;

    public Author addAuthor(Author author) {
        return authorRepo.save(author);
    }

    public Mono<Authordto> getAuthorByBookAuthorId(String bookAuthorId) {
        // Fetch the author entity from the database
        Author author = authorRepo.findByBookAuthorId(bookAuthorId);

        // Map Author entity to Authordto
        Authordto authordto = new Authordto();
        authordto.setAuthorId(author.getAuthorId());
        authordto.setBookAuthorId(author.getBookAuthorId());
        authordto.setAuthorName(author.getAuthorName());
        authordto.setAuthorEmail(author.getAuthorEmail());
        authordto.setAuthorBio(author.getAuthorBio());

        // Fetch the list of books asynchronously using WebClient and return a Mono<Authordto>
        return webClientBuilder.baseUrl("http://localhost:7072")
                .build()
                .get()
                .uri("/book/" + bookAuthorId)
                .retrieve()
                .bodyToFlux(new ParameterizedTypeReference<Bookdto>() {})  // Use Flux for non-blocking flow
                .collectList()  // Convert Flux<List<Bookdto>> to Mono<List<Bookdto>>
                .map(bookdtoList -> {
                    authordto.setBookdtos(bookdtoList);  // Set the list of Bookdto in Authordto
                    return authordto;  // Return the populated Authordto
                });
    }
}

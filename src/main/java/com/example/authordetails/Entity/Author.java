package com.example.authordetails.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Author {
    @Id
    private int authorId;
    private String bookAuthorId;
    private String authorName;
    private String authorEmail;
    private String authorBio;

}

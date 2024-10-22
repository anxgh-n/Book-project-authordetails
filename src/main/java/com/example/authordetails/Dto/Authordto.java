package com.example.authordetails.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authordto {
    private int authorId;
    private String bookAuthorId;
    private String authorName;
    private String authorEmail;
    private String authorBio;
}

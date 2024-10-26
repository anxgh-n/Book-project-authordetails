package com.example.authordetails.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Authordto {
    private int authorId;
    private String bookAuthorId;
    private String authorName;
    private String authorEmail;
    private String authorBio;
    private List<Bookdto> bookdtos;
}

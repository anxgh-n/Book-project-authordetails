package com.example.authordetails.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bookdto {
    private int bookId;
    private String bookTitle;
    private String bookPrice;
    private LocalDate bookPublished;
    private String bookImageUrl;
    private String bookAuthorId;
}

package com.example.authordetails.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Responsedto {
    private Authordto authordto;
    private List<Bookdto> bookdtos;
}

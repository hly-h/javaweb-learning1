package com.example.bookonline.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private Integer id;
    private String name;
    private String cover;
    private String author;
    private String publisher;
    private String publication_year;
    private String pages;
    private String price;
    private String category;
    private String description;
}

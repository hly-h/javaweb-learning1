package com.example.bookonline.service;

import com.example.bookonline.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book getBookById(int id);
}

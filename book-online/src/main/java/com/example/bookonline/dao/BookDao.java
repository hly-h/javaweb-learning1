package com.example.bookonline.dao;

import com.example.bookonline.entity.Book;

import java.util.List;

public interface BookDao {

    List<Book> selectAll();
    Book getBookById(int id);
}

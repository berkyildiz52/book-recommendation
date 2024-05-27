package com.example.book_recommendation.services.abstracts;

import com.example.book_recommendation.entities.Book;

import java.util.List;

public interface BookService {
    public List<Book> getAll();
}

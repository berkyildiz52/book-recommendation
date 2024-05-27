package com.example.book_recommendation.services.abstracts;

import com.example.book_recommendation.services.dtos.responses.BookResponse;

import java.util.List;

public interface BookService {
    public List<BookResponse> getAll();
}

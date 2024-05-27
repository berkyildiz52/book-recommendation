package com.example.book_recommendation.controllers;

import com.example.book_recommendation.services.abstracts.BookService;
import com.example.book_recommendation.services.dtos.responses.BookResponse;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public List<BookResponse> getAll(){
        return bookService.getAll();
    }
}

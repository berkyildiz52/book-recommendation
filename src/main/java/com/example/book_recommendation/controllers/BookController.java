package com.example.book_recommendation.controllers;

import com.example.book_recommendation.entities.Book;
import com.example.book_recommendation.services.abstracts.BookService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private final BookService bookService;

    @GetMapping("/all")
    public List<Book> getAll(){
        return bookService.getAll();
    }
}

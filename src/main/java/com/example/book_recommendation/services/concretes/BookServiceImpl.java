package com.example.book_recommendation.services.concretes;

import com.example.book_recommendation.entities.Book;
import com.example.book_recommendation.repositories.BookRepository;
import com.example.book_recommendation.services.abstracts.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }
}

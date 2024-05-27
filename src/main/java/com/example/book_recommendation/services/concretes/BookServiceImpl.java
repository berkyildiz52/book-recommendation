package com.example.book_recommendation.services.concretes;

import com.example.book_recommendation.entities.Book;
import com.example.book_recommendation.repositories.BookRepository;
import com.example.book_recommendation.services.abstracts.BookService;
import com.example.book_recommendation.services.dtos.responses.BookResponse;
import com.example.book_recommendation.services.mappers.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    @Override
    public List<BookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }
}

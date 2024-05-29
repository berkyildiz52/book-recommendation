package com.example.book_recommendation.services.abstracts;

import com.example.book_recommendation.services.dtos.requests.BookRequest;
import com.example.book_recommendation.services.dtos.responses.BookResponse;

import java.util.List;

public interface BookService {
    public List<BookResponse> getAll();

    public List<BookResponse> getBooksByGenre(String genre);

    public List<BookResponse> getBooksByLanguage(String language);

    public List<BookResponse> getBooksByRatingGreaterThan(double rating);

    public List<BookResponse> getBooksByRatingLessThan(double rating);

    public List<BookResponse> getBooksByLengthGreaterThan(int length);

    public List<BookResponse> getBooksByLengthLessThan(int length);

    public List<BookResponse> getBooksByYearGreaterThan(int year);

    public List<BookResponse> getBooksByYearLessThan(int year);

    public List<BookResponse> getBooksByAuthor(String author);

    public List<BookResponse> getBooksByTitle(String title);

    public List<BookResponse> getBooksByFilters(BookRequest bookRequest);

    List<String> getAllLanguages();

    List<String> getAllGenres();
}

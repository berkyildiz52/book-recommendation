package com.example.book_recommendation.controllers;

import com.example.book_recommendation.services.abstracts.BookService;
import com.example.book_recommendation.services.dtos.requests.BookRequest;
import com.example.book_recommendation.services.dtos.responses.BookResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/books")
public class BookController {
    private final BookService bookService;

    @GetMapping
    public ResponseEntity<List<BookResponse>> getAllBooks() {
        List<BookResponse> books = bookService.getAll();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/genre")
    public ResponseEntity<List<BookResponse>> getBooksByGenre(@RequestParam String genre) {
        List<BookResponse> books = bookService.getBooksByGenre(genre);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/language")
    public ResponseEntity<List<BookResponse>> getBooksByLanguage(@RequestParam String language) {
        List<BookResponse> books = bookService.getBooksByLanguage(language);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/rating/min")
    public ResponseEntity<List<BookResponse>> getBooksByRatingGreaterThan(@RequestParam double rating) {
        List<BookResponse> books = bookService.getBooksByRatingGreaterThan(rating);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/rating/max")
    public ResponseEntity<List<BookResponse>> getBooksByRatingLessThan(@RequestParam double rating) {
        List<BookResponse> books = bookService.getBooksByRatingLessThan(rating);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/length/min")
    public ResponseEntity<List<BookResponse>> getBooksByLengthGreaterThan(@RequestParam int length) {
        List<BookResponse> books = bookService.getBooksByLengthGreaterThan(length);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/length/max")
    public ResponseEntity<List<BookResponse>> getBooksByLengthLessThan(@RequestParam int length) {
        List<BookResponse> books = bookService.getBooksByLengthLessThan(length);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/year/min")
    public ResponseEntity<List<BookResponse>> getBooksByYearGreaterThan(@RequestParam int year) {
        List<BookResponse> books = bookService.getBooksByYearGreaterThan(year);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/year/max")
    public ResponseEntity<List<BookResponse>> getBooksByYearLessThan(@RequestParam int year) {
        List<BookResponse> books = bookService.getBooksByYearLessThan(year);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/author")
    public ResponseEntity<List<BookResponse>> getBooksByAuthor(@RequestParam String author) {
        List<BookResponse> books = bookService.getBooksByAuthor(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/title")
    public ResponseEntity<List<BookResponse>> getBooksByTitle(@RequestParam String title) {
        List<BookResponse> books = bookService.getBooksByTitle(title);
        return ResponseEntity.ok(books);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<BookResponse>> getBooksByFilters(@RequestBody BookRequest bookRequest) {
        List<BookResponse> books = bookService.getBooksByFilters(bookRequest);
        return ResponseEntity.ok(books);
    }
}

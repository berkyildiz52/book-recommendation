package com.example.book_recommendation.services.concretes;

import com.example.book_recommendation.core.exceptions.types.BusinessException;
import com.example.book_recommendation.core.services.abstracts.MessageService;
import com.example.book_recommendation.core.services.constants.Messages;
import com.example.book_recommendation.entities.Book;
import com.example.book_recommendation.repositories.BookRepository;
import com.example.book_recommendation.services.abstracts.BookService;
import com.example.book_recommendation.services.dtos.requests.BookRequest;
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
    private final MessageService messageService;

    @Override
    public List<BookResponse> getAll() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByGenre(String genre) {
        List<Book> books = bookRepository.findByGenre(genre);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByLanguage(String language) {
        List<Book> books = bookRepository.findByLanguage(language);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByRatingGreaterThan(double rating) {
        if(!ratingRange(rating)){
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.VALIDATION_RATING_ERROR));
        }
        List<Book> books = bookRepository.findByRatingGreaterThanEqual(rating);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByRatingLessThan(double rating) {
        if(!ratingRange(rating)){
            throw new BusinessException(messageService.getMessageWithArgs(Messages.BusinessErrors.VALIDATION_RATING_ERROR));
        }
        List<Book> books = bookRepository.findByRatingLessThanEqual(rating);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByLengthGreaterThan(int length) {
        List<Book> books = bookRepository.findByLengthGreaterThanEqual(length);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByLengthLessThan(int length) {
        List<Book> books = bookRepository.findByLengthLessThanEqual(length);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByYearGreaterThan(int year) {
        List<Book> books = bookRepository.findByYearGreaterThanEqual(year);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByYearLessThan(int year) {
        List<Book> books = bookRepository.findByYearLessThanEqual(year);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByAuthor(String author) {
        List<Book> books = bookRepository.findByAuthorContainingIgnoreCase(author);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByTitle(String title) {
        List<Book> books = bookRepository.findByTitleContainingIgnoreCase(title);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<BookResponse> getBooksByFilters(BookRequest bookRequest) {
        List<Book> books = bookRepository.findBooksByFilters(bookRequest);
        return books.stream()
                .map(BookMapper.INSTANCE::bookToBookDTO)
                .collect(Collectors.toList());
    }

    @Override
    public List<String> getAllLanguages() {
        return bookRepository.findDistinctLanguages();
    }

    @Override
    public List<String> getAllGenres() {
        return bookRepository.findDistinctGenres();
    }

    private boolean ratingRange(double rating){
        return rating < 5 && rating > 0;
    }
}

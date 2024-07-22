package com.example.book_recommendation.services;

import com.example.book_recommendation.core.exceptions.types.BusinessException;
import com.example.book_recommendation.core.services.abstracts.MessageService;
import com.example.book_recommendation.core.services.constants.Messages;
import com.example.book_recommendation.entities.Book;
import com.example.book_recommendation.repositories.BookRepository;
import com.example.book_recommendation.services.concretes.BookServiceImpl;
import com.example.book_recommendation.services.dtos.responses.BookResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BookServiceTests {

    @Mock
    private BookRepository bookRepository;

    @Mock
    private MessageService messageService;

    @InjectMocks
    private BookServiceImpl bookService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetBooksByRatingGreaterThan_ValidRating() {
        Book book1 = new Book();
        book1.setId(1L);
        book1.setTitle("Book 1");
        book1.setRating(4.5);

        when(bookRepository.findByRatingGreaterThanEqual(4.0)).thenReturn(Arrays.asList(book1));

        List<BookResponse> books = bookService.getBooksByRatingGreaterThan(4.0);

        assertNotNull(books);
        assertEquals(1, books.size());
        assertEquals("Book 1", books.get(0).getTitle());
    }

    @Test
    public void testGetBooksByRatingGreaterThan_InvalidRating() {
        when(messageService.getMessageWithArgs(Messages.BusinessErrors.VALIDATION_RATING_ERROR))
                .thenReturn("Rating must be between 0 and 5");

        BusinessException exception = assertThrows(BusinessException.class, () -> {
            bookService.getBooksByRatingGreaterThan(5.5);
        });

        assertEquals("Rating must be between 0 and 5", exception.getMessage());
    }

    // More tests for other methods can be added here
}

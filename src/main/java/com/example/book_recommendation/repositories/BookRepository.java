package com.example.book_recommendation.repositories;

import com.example.book_recommendation.entities.Book;
import com.example.book_recommendation.services.dtos.requests.BookRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByGenre(String genre);

    List<Book> findByLanguage(String language);

    List<Book> findByRatingLessThanEqual(double rating);

    List<Book> findByRatingGreaterThanEqual(double rating);

    List<Book> findByLengthLessThanEqual(int length);

    List<Book> findByLengthGreaterThanEqual(int length);

    List<Book> findByYearLessThanEqual(int year);

    List<Book> findByYearGreaterThanEqual(int year);

    @Query("SELECT b FROM Book b WHERE LOWER(b.author) LIKE LOWER(CONCAT('%', :author, '%'))")
    List<Book> findByAuthorContainingIgnoreCase(@Param("author") String author);

    @Query("SELECT b FROM Book b WHERE LOWER(b.title) LIKE LOWER(CONCAT('%', :title, '%'))")
    List<Book> findByTitleContainingIgnoreCase(@Param("title") String title);

    @Query("SELECT b FROM Book b WHERE " +
            "(:#{#request.genre} IS NULL OR b.genre = :#{#request.genre}) AND " +
            "(:#{#request.language} IS NULL OR b.language = :#{#request.language}) AND " +
            "(:#{#request.minRating} IS NULL OR b.rating >= :#{#request.minRating}) AND " +
            "(:#{#request.maxRating} IS NULL OR b.rating <= :#{#request.maxRating}) AND " +
            "(:#{#request.minLength} IS NULL OR b.length >= :#{#request.minLength}) AND " +
            "(:#{#request.maxLength} IS NULL OR b.length <= :#{#request.maxLength}) AND " +
            "(:#{#request.minYear} IS NULL OR b.year >= :#{#request.minYear}) AND " +
            "(:#{#request.maxYear} IS NULL OR b.year <= :#{#request.maxYear}) AND " +
            "(:#{#request.author} IS NULL OR LOWER(b.author) LIKE LOWER(CONCAT('%', :#{#request.author}, '%'))) AND " +
            "(:#{#request.title} IS NULL OR LOWER(b.title) LIKE LOWER(CONCAT('%', :#{#request.title}, '%')))")
    List<Book> findBooksByFilters(@Param("request") BookRequest request);

    @Query("SELECT DISTINCT b.language FROM Book b")
    List<String> findDistinctLanguages();

    @Query("SELECT DISTINCT b.genre FROM Book b")
    List<String> findDistinctGenres();

}

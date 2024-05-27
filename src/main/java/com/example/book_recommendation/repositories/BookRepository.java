package com.example.book_recommendation.repositories;

import com.example.book_recommendation.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Long> {
}

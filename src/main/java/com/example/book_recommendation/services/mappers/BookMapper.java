package com.example.book_recommendation.services.mappers;

import com.example.book_recommendation.entities.Book;
import com.example.book_recommendation.services.dtos.responses.BookResponse;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BookMapper {
    BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);

    BookResponse bookToBookDTO(Book book);
}

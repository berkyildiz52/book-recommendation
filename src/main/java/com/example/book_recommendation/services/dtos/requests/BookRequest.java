package com.example.book_recommendation.services.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookRequest {
    private String genre;
    private String language;
    private Double minRating;
    private Double maxRating;
    private Integer minLength;
    private Integer maxLength;
    private Integer minYear;
    private Integer maxYear;
    private String author;
    private String title;
}

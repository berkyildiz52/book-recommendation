package com.example.book_recommendation.services.dtos.requests;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
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
    @Min(value = 0, message = "Rating must be at least 0")
    private Double minRating;
    @Max(value = 5, message = "Rating must be at most 5")
    private Double maxRating;
    private Integer minLength;
    private Integer maxLength;
    private Integer minYear;
    private Integer maxYear;
    private String author;
    private String title;
}

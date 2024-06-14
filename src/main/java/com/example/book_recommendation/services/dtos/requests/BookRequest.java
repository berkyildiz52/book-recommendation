package com.example.book_recommendation.services.dtos.requests;

import com.example.book_recommendation.core.services.constants.Messages;
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
    @Min(value = 0, message = Messages.ValidationErrors.VALIDATION_RATING_MIN_ERROR)
    @Max(value = 5, message = Messages.ValidationErrors.VALIDATION_RATING_MAX_ERROR)
    private Double minRating;
    @Min(value = 0, message = Messages.ValidationErrors.VALIDATION_RATING_MIN_ERROR)
    @Max(value = 5, message = Messages.ValidationErrors.VALIDATION_RATING_MAX_ERROR)
    private Double maxRating;
    private Integer minLength;
    private Integer maxLength;
    private Integer minYear;
    private Integer maxYear;
    private String author;
    private String title;
}

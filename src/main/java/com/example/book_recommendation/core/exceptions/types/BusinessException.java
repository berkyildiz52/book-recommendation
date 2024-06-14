package com.example.book_recommendation.core.exceptions.types;

public class BusinessException extends RuntimeException{
    public BusinessException(String message) {
        super(message);
    }
}

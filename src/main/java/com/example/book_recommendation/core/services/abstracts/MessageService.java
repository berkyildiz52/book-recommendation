package com.example.book_recommendation.core.services.abstracts;

public interface MessageService {
    String getMessage(String key);
    String getMessageWithArgs(String key, Object... args);
}

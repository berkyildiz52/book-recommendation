package com.example.book_recommendation.core.exceptions;

import com.example.book_recommendation.core.exceptions.types.BusinessException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler
{
    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String,String> handleValidationException(MethodArgumentNotValidException exception)
    {
        Map<String,String> errors = new HashMap<>();

        List<FieldError> validationErrors = exception.getBindingResult().getFieldErrors();

        for(FieldError error : validationErrors)
        {
            errors.put(error.getField(), error.getDefaultMessage());
        }
        return errors;
    }
    @ExceptionHandler({BusinessException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleBusinessException(BusinessException exception)
    {
        return exception.getMessage();
    }
}
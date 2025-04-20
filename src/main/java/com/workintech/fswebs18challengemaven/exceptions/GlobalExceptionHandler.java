package com.workintech.fswebs18challengemaven.exceptions;

import com.workintech.fswebs18challengemaven.entity.Card;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleException(CardException burgerException) {
        CardErrorResponse errorResponse = new CardErrorResponse(burgerException.getMessage());
        return new ResponseEntity<>(errorResponse, burgerException.getHttpStatus());
    }

    @ExceptionHandler
    public ResponseEntity<CardErrorResponse> handleGeneralException(Exception exception) {
        CardErrorResponse errorResponse = new CardErrorResponse(exception.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}



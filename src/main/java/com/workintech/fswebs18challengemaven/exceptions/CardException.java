package com.workintech.fswebs18challengemaven.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CardException extends RuntimeException {
    private HttpStatus httpStatus;

    public CardException(String message, HttpStatus status) {
        super(message);
        this.httpStatus = status;
    }
}

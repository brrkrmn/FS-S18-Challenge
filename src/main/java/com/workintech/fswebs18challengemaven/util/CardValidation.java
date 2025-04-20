package com.workintech.fswebs18challengemaven.util;

import com.workintech.fswebs18challengemaven.entity.Card;
import com.workintech.fswebs18challengemaven.exceptions.CardException;
import org.springframework.http.HttpStatus;

public class CardValidation {
    public static void validate(Card card) {
        if (card.getId() == null) {
            throw new CardException("Id cannot be empty", HttpStatus.BAD_REQUEST);
        }
    }
}

package com.workintech.fswebs18challengemaven.controller;

import com.workintech.fswebs18challengemaven.exceptions.CardException;
import com.workintech.fswebs18challengemaven.repository.CardRepository;
import com.workintech.fswebs18challengemaven.entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardController {
    private CardRepository cardRepository;

    @Autowired
    public CardController(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @GetMapping()
    public List<Card> getAll() {
        return cardRepository.findAll();
    }

    @GetMapping("/byColor/{color}")
    public List<Card> getByColor(@PathVariable String color) {
        List<Card> cards = cardRepository.findByColor(color);
        if (cards.isEmpty()) {
            throw new CardException("Cards could not be found", HttpStatus.NOT_FOUND);
        }
        return cards;
    }

    @PostMapping()
    public Card create(@RequestBody Card card) {
        return cardRepository.save(card);
    }

    @PutMapping("/")
    public Card update(@RequestBody Card card) {
        return cardRepository.update(card);
    }

    @DeleteMapping("/{id}")
    public Card delete(@PathVariable long id) {
        return cardRepository.remove(id);
    }

    @GetMapping("/byValue/{value}")
    public List<Card> getByValue(@PathVariable int value) {
        return cardRepository.findByValue(value);
    }

    @GetMapping("/byType/{type}")
    public List<Card> getByType(@PathVariable String type) {
        return cardRepository.findByType(type);
    }
}

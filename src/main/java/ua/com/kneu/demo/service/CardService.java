package ua.com.kneu.demo.service;

import org.springframework.stereotype.Service;
import ua.com.kneu.demo.entity.Card;
import ua.com.kneu.demo.repository.CardRepository;

import java.util.List;

@Service
public class CardService {
    private final CardRepository cardRepository;

    public CardService(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    public Card save(Card card) {
        return cardRepository.save(card);
    }

    public Card findById(Long id) {
        return cardRepository.findById(id).orElse(null);
    }

    public List<Card> findAll() {
        return cardRepository.findAll();
    }

    public void deleteById(Long id) {
        cardRepository.deleteById(id);
    }

    public void deleteAll() {
        cardRepository.deleteAll();
    }

}

package ua.com.kneu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.demo.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long> {
}

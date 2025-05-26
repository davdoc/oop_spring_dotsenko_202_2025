package ua.com.kneu.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "cards")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardNumber;
    private String accountNumber;
    private String expirationDate;
    private String cvv;
    private String type;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Customer customer;

    @OneToOne(mappedBy = "card")
    private Account account;
}

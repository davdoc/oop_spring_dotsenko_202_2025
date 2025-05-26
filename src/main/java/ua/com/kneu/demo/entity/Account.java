package ua.com.kneu.demo.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String accountNumber;
    private Float balance;

    @OneToOne
    @MapsId
    @MapKey
    @JoinColumn(name = "card_id")
    private Card card;
}

package ua.com.kneu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.demo.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

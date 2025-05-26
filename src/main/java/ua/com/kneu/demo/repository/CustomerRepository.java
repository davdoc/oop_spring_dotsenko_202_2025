package ua.com.kneu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.demo.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}

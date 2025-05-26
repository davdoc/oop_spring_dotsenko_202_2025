package ua.com.kneu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.demo.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

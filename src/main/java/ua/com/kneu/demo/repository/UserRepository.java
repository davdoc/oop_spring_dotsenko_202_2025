package ua.com.kneu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.demo.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}

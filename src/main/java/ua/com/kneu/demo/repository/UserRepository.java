package ua.com.kneu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.demo.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAllByUsername(String username);

    User findByUsername(String username);
}

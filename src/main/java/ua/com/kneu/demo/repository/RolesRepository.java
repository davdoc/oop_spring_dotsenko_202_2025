package ua.com.kneu.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.com.kneu.demo.entity.Roles;

public interface RolesRepository extends JpaRepository<Roles, Long> {
}

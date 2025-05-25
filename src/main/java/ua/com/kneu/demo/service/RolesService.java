package ua.com.kneu.demo.service;

import org.springframework.stereotype.Service;
import ua.com.kneu.demo.entity.Roles;
import ua.com.kneu.demo.repository.RolesRepository;

import java.util.List;

@Service
public class RolesService {
    private final RolesRepository rolesRepository;

    public RolesService(RolesRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    public Roles save(Roles roles) {
        return rolesRepository.save(roles);
    }

    public Roles findById(Long id) {
        return rolesRepository.findById(id).orElse(null);
    }

    public List<Roles> findAll() {
        return rolesRepository.findAll();
    }

    public void deleteById(Long id) {
        rolesRepository.deleteById(id);
    }

    public void deleteAll() {
        rolesRepository.deleteAll();
    }

}

package ua.com.kneu.demo.service;

import org.springframework.stereotype.Service;
import ua.com.kneu.demo.entity.Customer;
import ua.com.kneu.demo.repository.CustomerRepository;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    public void deleteAll() {
        customerRepository.deleteAll();
    }

    public void saveNewCustomer(Customer customer) {
        customerRepository.save(customer);
    }

}

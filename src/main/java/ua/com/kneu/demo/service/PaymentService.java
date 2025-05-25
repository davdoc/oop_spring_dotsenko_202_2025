package ua.com.kneu.demo.service;

import org.springframework.stereotype.Service;
import ua.com.kneu.demo.entity.Payment;
import ua.com.kneu.demo.repository.PaymentRepository;

import java.util.List;

@Service
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment save(Payment payment) {
        return paymentRepository.save(payment);
    }

    public Payment findById(Long id){
        return paymentRepository.findById(id).orElse(null);
    }

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public void deleteById(Long id){
        paymentRepository.deleteById(id);
    }

    public void deleteAll(){
        paymentRepository.deleteAll();
    }

}

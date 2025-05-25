package ua.com.kneu.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kneu.demo.entity.Payment;
import ua.com.kneu.demo.service.CustomerService;
import ua.com.kneu.demo.service.PaymentService;
import java.util.Date;

@Controller
public class PaymentController {
    private final PaymentService paymentService;
    private final CustomerService customerService;

    public PaymentController(PaymentService paymentService, CustomerService customerService) {
        this.paymentService = paymentService;
        this.customerService = customerService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("message", "Welcome to payment service!");
        model.addAttribute("payments", paymentService.findAll());
        return "index";
    }

    @PostMapping("/makePayment")
    public String makePayment(@RequestParam("description") String describtion,
                              @RequestParam("amount") String amount) {
        Payment payment = new Payment();
        payment.setDescription(describtion);
        payment.setAmount(Float.parseFloat(amount));
        payment.setDate(new Date());
        paymentService.save(payment);
        return "redirect:/";
    }
}

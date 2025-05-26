package ua.com.kneu.demo.controller;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.com.kneu.demo.entity.Customer;
import ua.com.kneu.demo.entity.Payment;
import ua.com.kneu.demo.entity.User;
import ua.com.kneu.demo.service.CustomerService;
import ua.com.kneu.demo.service.PaymentService;
import ua.com.kneu.demo.service.RolesService;
import ua.com.kneu.demo.service.UserService;

import java.util.Date;

@Controller
public class UserController {
    private final UserService userService;
    private final CustomerService customerService;
    private final RolesService rolesService;
    private final PaymentService paymentService;

    public UserController(UserService userService, CustomerService customerService, RolesService rolesService,
                          PaymentService paymentService) {
        this.userService = userService;
        this.customerService = customerService;
        this.rolesService = rolesService;
        this.paymentService = paymentService;
    }

    @GetMapping("/")
    public String getHome(Model model) {
        model.addAttribute("message", "Welcome to payment service!");
        model.addAttribute("payments", paymentService.findAll());
        return "index";
    }

    @GetMapping("/user")
    public String getUser() {
        return "user";
    }

    @GetMapping("/admin")
    public String getAdmin() {
        return "admin";
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @GetMapping("/registration")
    public String getRegistration(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("customer", new Customer());
        return "registration";
    }


    @PostMapping("/registration")
    public String saveNewCustomer(User user,
                                  BindingResult bindingResult1,
                                  Customer customer,
                                  BindingResult bindingResult2
    ){

        if(bindingResult1.hasErrors()){
            return "/registration";
        }

        if(bindingResult2.hasErrors()){
            return "/registration";
        }

        if(userService.getLogicByUser(user.getUsername())){
            return "/registration";
        }

        user.setRole(rolesService.findById(9L));
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        User user1 = userService.save(user);

        customer.setUser(user1);

        customerService.saveNewCustomer(customer);

        return "redirect:/login";
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

package ua.com.kneu.demo.service;

import org.springframework.stereotype.Service;
import ua.com.kneu.demo.repository.AccountRepository;
import ua.com.kneu.demo.entity.Account;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account save(Account account) {
        return accountRepository.save(account);
    }

    public Account findById(Long id){
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }

    public void deleteAll(){
        accountRepository.deleteAll();
    }
}

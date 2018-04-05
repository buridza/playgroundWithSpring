package by.itacademy.impl;

import by.itacademy.entity.account.AccountStatus;
import by.itacademy.interfaces.AccountService;
import by.itacademy.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void changeStatus(Serializable id, AccountStatus status) {
        accountRepository.changeAccountStatus(id, status);
    }
}

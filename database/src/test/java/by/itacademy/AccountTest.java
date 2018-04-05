package by.itacademy;

import by.itacademy.entity.account.Account;
import by.itacademy.entity.account.AccountStatus;
import by.itacademy.repository.AccountRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountTest extends BaseTest {
    @Autowired
    AccountRepository accountRepository;

    @Test
    public void accountTest() {
        List<Account> all = accountRepository.findAll();
        all.forEach(account -> System.out.println(account.getId()+" "+account.getStatus()));
    }
}

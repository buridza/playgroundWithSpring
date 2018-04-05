package by.itacademy.interfaces;

import by.itacademy.entity.account.AccountStatus;

import java.io.Serializable;

public interface AccountService {
    void changeStatus(Serializable id, AccountStatus deleted);
}

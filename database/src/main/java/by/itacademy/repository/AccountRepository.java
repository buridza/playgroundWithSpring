package by.itacademy.repository;

import by.itacademy.entity.account.Account;
import by.itacademy.entity.account.AccountStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;

import java.io.Serializable;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("UPDATE Account SET status = newStatus where id = entityId")
    void changeAccountStatus(Serializable entityId, AccountStatus newStatus);

}

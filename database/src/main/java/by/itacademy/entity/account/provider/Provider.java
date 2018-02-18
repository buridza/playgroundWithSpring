package by.itacademy.entity.account.provider;

import by.itacademy.entity.account.Account;
import by.itacademy.entity.account.Address;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Provider extends Account {
    @Column(nullable = false, unique = true)
    @Embedded
    private Requisites requisites;

    public Provider(Address address, String name, String login, String password, String email, Requisites requisites) {
        super(address, name, login, password, email);
        this.requisites = requisites;
    }
}

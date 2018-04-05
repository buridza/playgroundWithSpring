package by.itacademy.entity.account;

import by.itacademy.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "account")
public abstract class Account extends BaseEntity {
    @Version
    private int version;
    @Embedded
    private Address address;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "login", nullable = false, unique = true)
    private String login;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private AccountStatus status = AccountStatus.ACTIVE;

    public Account(Address address, String name, String login, String password, String email) {
        this.address = address;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
    }

    public Account(Address address, String name, String login, String password, String email, AccountStatus status) {
        this.address = address;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.status = status;
    }
}

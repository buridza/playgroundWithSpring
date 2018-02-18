package by.itacademy.entity.account.admin;


import by.itacademy.entity.account.Account;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
@ToString(callSuper = true)
@Entity
@DiscriminatorValue("admin")
public class Admin extends Account {
    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    private Role role;
}


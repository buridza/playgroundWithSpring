package by.itacademy.impl;

import by.itacademy.entity.account.Address;
import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.account.user.Role;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AccountUser {

    private LocalDate dateOfBirthday;
    private Role role=Role.USER;
    private Language language;
    private Address address;
    private String name;
    private String login;
    private String password;
    private String email;
}

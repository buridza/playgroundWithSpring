package by.itacademy.controller;

import by.itacademy.impl.AccountUserDTO;
import by.itacademy.interfaces.UserService;
import by.itacademy.entity.account.user.Language;
import by.itacademy.exception.NotUniqueException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class RegistrationController {


    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/registration")
    public String showRegistrationPage(AccountUserDTO accountUserDTO) {
        return "anonymous/Registration";
    }

    @ModelAttribute
    public AccountUserDTO accountUser() {
        return new AccountUserDTO();
    }
    @ModelAttribute("languageList")
    public Language[] language() {
        return Language.values();
    }

    @PostMapping("/registration")
    public String createNewUser(AccountUserDTO user, Model model, @RequestParam String date) {
        try {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setDateOfBirthday(LocalDate.parse(date));
            model.addAttribute("user", userService.registerNewUser(user));
            return "login";
        } catch (NotUniqueException exception) {
            model.addAttribute("error", exception.getMessage());
            return "redirect:/registration";
        }
    }
}

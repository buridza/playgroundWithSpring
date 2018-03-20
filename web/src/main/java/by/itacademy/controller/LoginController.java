package by.itacademy.controller;

import by.itacademy.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    private final UserService userService;

    @Autowired
    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/Login")
    public String showLoginController() {
        return "Login";
    }

    @PostMapping("/Login")
    public String succesfulLogin(@RequestParam String login) {
        userService.loadUserByUsername(login);
        return "anonymous/Login";
    }
}

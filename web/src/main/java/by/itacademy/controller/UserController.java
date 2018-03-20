package by.itacademy.controller;

import by.itacademy.UserService;
import by.itacademy.entity.account.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@SessionAttributes("user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("userConfigurePage")
    public String toUserConfig(@ModelAttribute User user) {
        System.out.println("userConfigurePage");
        user.setDateOfBirthday(LocalDate.parse(user.getDateOfBirthday().toString()));
        return "auth/userConfigurePage";
    }

    @GetMapping("UserPage")
    public String showUserPage() {
        return "auth/UserPage";
    }

    @PostMapping("paymentConfirmation")
    public String paymentConfitmation(@RequestParam Long id,  Model model) {
        model.addAttribute(userService.addGameForUser(SecurityContextHolder.getContext().getAuthentication().getName(), id));
        return "/auth/UserPage";
    }

    @GetMapping("edit")
    public String toEdit(Model model, User user) {
        model.addAttribute("user", user);
        return "auth/userConfigurePage";
    }

    @PostMapping("edit/{id}")
    public String edit(User user, @PathVariable Long id) {

        System.out.println("i'm here");
        //User name = userService.saveUserByUserName(SecurityContextHolder.getContext().getAuthentication().getName(), user);
        User name = userService.updateUserById(user, id);
        System.out.println(name);
        return "auth/UserPage";
    }

}

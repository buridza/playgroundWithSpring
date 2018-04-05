package by.itacademy.controller;

import by.itacademy.entity.account.user.Role;
import by.itacademy.interfaces.UserService;
import by.itacademy.entity.account.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionAttributeStore;
import org.springframework.web.context.annotation.SessionScope;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;

@Controller
@SessionAttributes({"user", "filter"})
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

    @ModelAttribute
    public Model model(Model model) {
        model.addAttribute("user", userService.getUserByLogin(SecurityContextHolder.getContext().getAuthentication().getName()));
        return model;
    }

    @GetMapping("UserPage")
    public String showUserPage() {
        //System.out.println(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        return "auth/UserPage";
    }

    @PostMapping("UserPage")
    public String paymentConfitmation(@RequestParam Long id, Model model) {
        model.addAttribute(userService.addGameForUser(SecurityContextHolder.getContext().getAuthentication().getName(), id));
        return "/auth/UserPage";
    }

    @GetMapping("InformationPage")
    public String showInformationPage() {
        return "auth/InformationPage";
    }

    @GetMapping("edit")
    public String toEdit(Model model, User user) {
        model.addAttribute("user", user);
        return "auth/userConfigurePage";
    }

    @PostMapping("edit")
    public String edit(User user/*, @PathVariable Long id*/) {

        System.out.println("i'm here");
        //User name = userService.saveUserByUserName(SecurityContextHolder.getContext().getAuthentication().getName(), user);
        User name = userService.updateUserById(user/*, id*/);
        System.out.println(name);
        return "redirect:UserPage";
    }
   /* @GetMapping("local")
    public String localChange(@RequestParam String local) {
        return "redirect:" +
    }*/

}

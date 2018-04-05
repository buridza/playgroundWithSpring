package by.itacademy.controller;

import by.itacademy.entity.account.user.User;
import by.itacademy.impl.Filter;
import by.itacademy.interfaces.ProviderService;
import by.itacademy.interfaces.PurchaseService;
import by.itacademy.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class AdminController {

    private final UserService userService;
    private final ProviderService providerService;
    private final PurchaseService purchaseServide;

    @Autowired
    public AdminController(UserService userService, ProviderService providerService, PurchaseService purchaseServide) {
        this.userService = userService;
        this.providerService = providerService;
        this.purchaseServide = purchaseServide;
    }

    @ModelAttribute
    public Filter addFilterInSession() {
        return new Filter();
    }

    @GetMapping("Admin")
    public String showAdminPage() {
        return "auth/adminPages/AdminPage";
    }

    @GetMapping("AllUsers")
    public String showAllUsers(Model model, Filter filter) {


        model.addAttribute("entities", userService.entities(filter));
        return "auth/adminPages/AllUsers";
    }

    @GetMapping("AllPurchase")
    public String showAllPurchase(Model model, Filter filter) {
        model.addAttribute("entities", purchaseServide.entities(filter));
        return "auth/adminPages/AllPurchase";
    }

    @GetMapping("AllProvider")
    public String showAllProvider(Model model, Filter filter) {
        model.addAttribute("entities", providerService.entities(filter));
        return "auth/adminPages/AllProvider";
    }

    @GetMapping("EditProvider")
    public String showProviderEdit(@RequestParam String login, Model model) {
        System.out.println(providerService.getProviderByLogin(login));
        model.addAttribute("provider", providerService.getProviderByLogin(login));
        return "/auth/adminPages/EditEntityPage";
    }

    @PostMapping("EditProvider")
    public String backToAllPRovider(@RequestParam String login, @RequestParam Long id) {
        providerService.editProvider(login, id);
        return "redirect:AllProvider";
    }
}

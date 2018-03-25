package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {
    @GetMapping("Admin")
    public String showAdminPage() {
        return "auth/AdminPage";
    }
}

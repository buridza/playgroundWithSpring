package by.itacademy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Logout {

    @RequestMapping
    public String logout() {
        return "/Logout";
    }
    /*@PostMapping
    public String logout() {
        return "/Logout";
    }*/
}

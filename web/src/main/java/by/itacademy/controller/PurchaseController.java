package by.itacademy.controller;

import by.itacademy.GameService;
import by.itacademy.UserService;
import by.itacademy.entity.account.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PurchaseController {

    /* @ModelAttribute("gameOrder")
     public Game getGame(Game game) {
         return game;
     }*/
    private final GameService gameService;
    private final UserService userService;

    @Autowired
    public PurchaseController(GameService gameService, UserService userService) {
        this.gameService = gameService;
        this.userService = userService;
    }

    @RequestMapping("createOrder")
    public String createOrder(@RequestParam Long id, Model model) {
        //model.addAttribute("game", game);
        model.addAttribute("game", gameService.getGameById(id));
        // SecurityContextHolder.getContext().getAuthentication().getAuthorities().forEach(System.out::println);
        System.out.println();
        return "/auth/Purchase";
    }


}

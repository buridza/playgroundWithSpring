package by.itacademy.controller;

import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.game.Game;
import by.itacademy.impl.Filter;
import by.itacademy.interfaces.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.method.annotation.SessionAttributesHandler;

@Controller
@SessionScope
public class FirstPageController {

    private final GameService gameService;

    @Autowired
    public FirstPageController(GameService gameService) {
        this.gameService = gameService;
    }

    @ModelAttribute("filter")
    public Filter filter() {
        return new Filter();
    }

    @ModelAttribute("languages")
    public Language[] languages() {
        return Language.values();
    }

    @ModelAttribute("games")
    public Page<Game> nextPage(Filter filter) {
        return gameService.nextPageWithFilter(filter);
    }


    @GetMapping("/filter")
    public String enableFilter(Filter filter) {
        return "auth/firstPage";
    }

    @GetMapping("/firstPage")
    public String showFirstPage() {

        return "auth/firstPage";
    }

/*    @GetMapping("")
    public String showIndexPage() {
        return "auth/firstPage";
    }*/

}

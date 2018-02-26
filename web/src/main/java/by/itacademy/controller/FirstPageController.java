package by.itacademy.controller;

import by.itacademy.Filter;
import by.itacademy.GameService;
import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.game.Game;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class FirstPageController {

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
        return new GameService().nextPageWithFilter(filter);
    }
 /*   @ModelAttribute("totalPages")
    public int getTotalPages(Filter filter, GameService gameService) {
        return gameService.nextPageWithFilter(filter).getTotalPages();
    }*/

    @GetMapping("/filter")
    public String enableFilter(Filter filter, GameService gameService) {
        //System.out.println(gameService.nextPageWithFilter(filter));
        return "firstPage";
    }

    @GetMapping("/firstPage")
    public String showFirstPage() {
        return "firstPage";
    }
}

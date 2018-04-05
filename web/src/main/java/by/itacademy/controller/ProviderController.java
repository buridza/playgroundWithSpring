package by.itacademy.controller;

import by.itacademy.entity.account.AccountStatus;
import by.itacademy.entity.account.provider.Provider;
import by.itacademy.entity.account.user.User;
import by.itacademy.entity.game.Game;
import by.itacademy.interfaces.AccountService;
import by.itacademy.interfaces.GameService;
import by.itacademy.interfaces.ProviderService;
import by.itacademy.interfaces.UserService;
import by.itacademy.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.annotation.SessionScope;

@Controller
public class ProviderController {

    private final ProviderService providerService;
    private final AccountService accountService;
    private final GameService gameService;

    @Autowired
    public ProviderController(ProviderService providerService, AccountService accountService, GameService gameService) {
        this.providerService = providerService;
        this.accountService = accountService;
        this.gameService = gameService;
    }

    @ModelAttribute
    public Provider provider() {
        return new Provider();
    }

    @RequestMapping("ProviderPage")
    public String providerAbout() {
        return "auth/ProviderPage";
    }

    @GetMapping("MenuForAddNewGame")
    public String showMenuForAddNewGame() {
        return "auth/ProviderAddNewGame";
    }

    @PostMapping("SuccesfulAddition")
    public String addNewGameSuccesful(Game game) {
        gameService.addNewGame(game);
        return "auth/InformationPage";
    }
    @PostMapping("DeleteAccount")
    public String deleteYorself(@SessionAttribute User user) {
        accountService.changeStatus(user.getId(), AccountStatus.DELETED);
        return "auth/InformationPage";
    }

    @PostMapping("Reestablish")
    public String reestablish(@SessionAttribute User user) {
        accountService.changeStatus(user.getId(), AccountStatus.ACTIVE);
        return "auth/UserPage";
    }

}

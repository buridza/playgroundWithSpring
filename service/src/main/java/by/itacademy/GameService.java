package by.itacademy;

import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.game.Game;
import by.itacademy.repository.GameRepository;
import config.ServiceConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private GameRepository gameRepository;
    public GameService() {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ServiceConfig.class);
        gameRepository = applicationContext.getBean(GameRepository.class);
        System.out.println(gameRepository);
    }
    public Page<Game> nextPageWithFilter(int page, int size, String name, int cost, int ageRest, Language language) {
        Page<Game> games;
        if (language == null) {
           games = gameRepository.findGamesByNameContainsAndCostBeforeAndAgeRestrictionsAfter(name, cost, ageRest, new PageRequest(page, size));
        } else {
           games = gameRepository.findGamesByNameContainsAndCostAfterAndAgeRestrictionsAfterAndLanguage(name, cost, ageRest, language, new PageRequest(page, size));
        }
        return games;
    }
}

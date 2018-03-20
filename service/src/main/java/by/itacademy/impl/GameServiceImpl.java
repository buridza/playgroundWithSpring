package by.itacademy.impl;

import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.game.Game;
import by.itacademy.repository.GameRepository;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

@Service
@Transactional
@NoArgsConstructor
public class GameServiceImpl implements by.itacademy.GameService{

    private GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    /*public GameService() {
        AnnotationConfigApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(ServiceConfig.class);
        gameRepository = applicationContext.getBean(GameRepository.class);
        System.out.println(gameRepository);
    }*/



    public Page<Game> nextPageWithFilter(int page, int size, String name, int cost, int ageRest, Language language) {
        Page<Game> games;
        if (language == null) {
           games = gameRepository.findGamesByNameContainsAndCostBeforeAndAgeRestrictionsAfter(name, cost, ageRest, new PageRequest(page, size));
        } else {
           games = gameRepository.findGamesByNameContainsAndCostBeforeAndAgeRestrictionsAfterAndLanguage(name, cost, ageRest, language, new PageRequest(page, size));
        }
        return games;
    }
    public Page<Game> nextPageWithFilter(Filter filter) {
        Page<Game> games;
        if (filter.getLanguage() == null) {
            games = gameRepository
                    .findGamesByNameContainsAndCostBeforeAndAgeRestrictionsAfter(
                            filter.getName(),
                            filter.getCost(),
                            filter.getAgeRestriction(),
                            new PageRequest(filter.getNextPage(), filter.getNumberOfRows()));
                           // new PageRequest(0, 1));

        } else {
            games = gameRepository.findGamesByNameContainsAndCostBeforeAndAgeRestrictionsAfterAndLanguage(
                    filter.getName(),
                    filter.getCost(),
                    filter.getAgeRestriction(),
                    filter.getLanguage(),
                    new PageRequest(filter.getNextPage(), filter.getNumberOfRows()));
            //new PageRequest(0, 1));
        }

        return games;
    }

    @Override
    public Game getGameById(Serializable id) {
        return gameRepository.findOne((Long)id);
    }
}

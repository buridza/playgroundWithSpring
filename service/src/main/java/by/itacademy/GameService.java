package by.itacademy;

import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.game.Game;
import by.itacademy.impl.Filter;
import org.springframework.data.domain.Page;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;

public interface GameService {
    public Page<Game> nextPageWithFilter(int page, int size, String name, int cost, int ageRest, Language language);
    public Page<Game> nextPageWithFilter(Filter filter);
    Game getGameById(Serializable id);
}

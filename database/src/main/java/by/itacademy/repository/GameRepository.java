package by.itacademy.repository;

import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.game.Game;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface GameRepository extends PagingAndSortingRepository<Game, Long>, JpaRepository<Game, Long> {
    Page<Game> findGamesByNameContainsAndCostAfterAndAgeRestrictionsAfterAndLanguage(String name, int cost, int ageRest, Language language, Pageable pageable);
    Page<Game> findGamesByNameContainsAndCostBeforeAndAgeRestrictionsAfter(String name, int cost, int ageRest, Pageable pageable);
}

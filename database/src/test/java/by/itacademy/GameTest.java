package by.itacademy;

import by.itacademy.entity.account.user.Language;
import by.itacademy.entity.game.Game;
import by.itacademy.repository.GameRepository;
import by.itacademy.repository.ProviderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class GameTest extends BaseTest {
    @Autowired
    GameRepository gameRepository;
    @Autowired
    ProviderRepository providerRepository;

    public String gameName(int rand) {

        String str = "";
        Random random = new Random();
        for (int i = 0; i < rand; i++) {
            str += String.copyValueOf(Character.toChars(65 + new Random().nextInt(47)));
        }
        return str;

    }
    public String multiplier(String str, int number) {
        String strConcat="";
        for (int i = 0; i < number; i++) {
            strConcat+=str;
        }
        return strConcat;
    }

    @Test
    public void testSave() {
        Game game = new Game();
        game.setAgeRestrictions(new Random().nextInt(21));
        game.setCost(new Random().nextInt(1000));
        game.setLanguage(Language.values()[new Random().nextInt(4)]);
        game.setName(gameName(new Random().nextInt(20)));
        game.setNumberOfPlayers(new Random().nextInt(10));
        game.setProvider(providerRepository.findOne((long)new Random().nextInt(38)));
        game.setRules("doing smthg"+ multiplier("!", new Random().nextInt(20)));
        System.out.println(game.getRules());
        gameRepository.save(game);
    }
    @Test
    public void findTest() {
        gameRepository.findAll().forEach(System.out::println);
    }
}

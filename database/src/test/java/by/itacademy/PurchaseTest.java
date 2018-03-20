package by.itacademy;

import by.itacademy.entity.Purchase;
import by.itacademy.entity.account.user.User;
import by.itacademy.entity.game.Game;
import by.itacademy.repository.GameRepository;
import by.itacademy.repository.PurchaseRepository;
import by.itacademy.repository.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;

public class PurchaseTest extends BaseTest{
    @Autowired
    PurchaseRepository purchaseRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    UserRepository userRepository;
    @Test
    public void savePurchase() {
        Purchase purchase = new Purchase();
        purchase.setDate(LocalDate.now());
        List<Game> all = gameRepository.findAll();
        purchase.setGame(all.get(new Random().nextInt(all.size())));
        List<User> users = userRepository.findAll();
        purchase.setUser(users.get(0));
        purchase.setPaymentStatus(new Random().nextBoolean());
        purchaseRepository.save(purchase);
    }

    @Test
    public void findTest() {
        purchaseRepository.findAll();
    }

    @Test
    public void updateTest() {
        List<Purchase> purchasesByPaymentStatus = purchaseRepository.findPurchasesByPaymentStatus(false);
        purchasesByPaymentStatus.forEach(purchase -> purchase.setPaymentStatus(true));
        purchaseRepository.save(purchasesByPaymentStatus);
    }
}

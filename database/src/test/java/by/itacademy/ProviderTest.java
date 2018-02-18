package by.itacademy;

import by.itacademy.entity.account.provider.Provider;
import by.itacademy.repository.ProviderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public class ProviderTest extends BaseTest {
    @Autowired
    ProviderRepository providerRepository;

    @Test
    public void requisitiesByProviderName() {
        //providerRepository.findProviderByName("Ivan36");
        Iterable<Provider> providers = providerRepository.findAll();
        providers.forEach(System.out::println);
        for (int i = 0; i < 3; i++) {
            Page<Provider> all = providerRepository.findAll(new PageRequest(i, 5));
            for (Provider pr: all) {
                System.out.println("page number "+i+" : "+pr.getName());
            }
        }


    }
}

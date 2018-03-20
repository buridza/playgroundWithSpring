package by.itacademy;

import by.itacademy.entity.account.Address;
import by.itacademy.entity.account.provider.Provider;
import by.itacademy.entity.account.provider.Requisites;
import by.itacademy.repository.ProviderRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;

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
            for (Provider pr : all) {
                System.out.println("page number " + i + " : " + pr.getName());
            }
        }
    }
    @Test
    public void saveProvider() {
        Requisites requisites = new Requisites("User",
                1234L,
                34563L,
                "56545");
        Provider provider = new Provider(new Address("Minsk", "Lopatina",
                20, 30),"NIrVaNA", "BestCompany",
                "12345", "nirvana@gmail.com",
                requisites);
        providerRepository.save(provider);
    }
    @Test
    public void setTest() {
        List<Provider> all = providerRepository.findAll();
        all.forEach(provider -> provider.setName("Ignat"));
        providerRepository.save(all);
        providerRepository.findAll().forEach(System.out::println);
    }
}

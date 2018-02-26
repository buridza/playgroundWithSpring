package by.itacademy.repository;

import by.itacademy.entity.account.provider.Provider;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProviderRepository extends PagingAndSortingRepository<Provider, Long> {
    Provider findProviderByName(String name);

}

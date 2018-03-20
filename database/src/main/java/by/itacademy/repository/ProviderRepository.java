package by.itacademy.repository;

import by.itacademy.entity.account.provider.Provider;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProviderRepository extends JpaRepository<Provider, Long> {
    Provider findProviderByName(String name);
}

package by.itacademy.interfaces;

import by.itacademy.entity.account.provider.Provider;
import by.itacademy.impl.Filter;
import org.springframework.data.domain.Page;

public interface ProviderService {
    Provider getProviderByLogin(String login);
    Page<Provider> entities(Filter filter);
    void editProvider(String login, Long id);
}

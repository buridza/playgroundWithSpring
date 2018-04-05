package by.itacademy.impl;

import by.itacademy.entity.account.AccountStatus;
import by.itacademy.interfaces.ProviderService;
import by.itacademy.entity.account.provider.Provider;
import by.itacademy.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class ProviderServiceImpl implements ProviderService {
    private final ProviderRepository providerRepository;

    @Autowired
    public ProviderServiceImpl(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @Override
    public Provider getProviderByLogin(String login) {
        return providerRepository.findProviderByName(login);
    }

    @Override
    public Page<Provider> entities(Filter filter) {

        return providerRepository.findAll(new PageRequest(filter.getNextPage(), filter.getNumberOfRows()));
    }

    @Override
    public void editProvider(String login, Long id) {
        Provider one = providerRepository.findOne(id);
                one.setLogin(login);
        providerRepository.save(one);
    }

}

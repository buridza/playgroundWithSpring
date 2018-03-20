package by.itacademy.impl;

import by.itacademy.ProviderService;
import by.itacademy.entity.account.provider.Provider;
import by.itacademy.repository.ProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

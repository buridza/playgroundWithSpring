package by.itacademy.repository;

import by.itacademy.entity.account.AccountStatus;
import by.itacademy.entity.account.provider.Provider;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.annotation.QueryAnnotation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface ProviderRepository extends JpaRepository<Provider, Long>{
    Provider findProviderByName(String name);


}

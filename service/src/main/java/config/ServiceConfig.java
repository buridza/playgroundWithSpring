package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

@Configuration
@Service
@ComponentScan(basePackages = "by.itacademy.impl")
//@Import(value = PersistenceConfig.class)
public class ServiceConfig {
}

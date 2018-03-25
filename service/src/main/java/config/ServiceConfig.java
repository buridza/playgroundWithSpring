package config;


import by.itacademy.aspect.Log;
import by.itacademy.config.PersistenceConfig;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.Service;

@Configuration
@Service
@ComponentScan(basePackages = "by.itacademy.impl")
@EnableAspectJAutoProxy
@Import(value = PersistenceConfig.class)
public class ServiceConfig {
    @Bean
    public Log loger() {
        return new Log();
    }

}

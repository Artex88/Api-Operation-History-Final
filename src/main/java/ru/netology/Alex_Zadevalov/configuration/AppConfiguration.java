package ru.netology.Alex_Zadevalov.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.Alex_Zadevalov.service.AsyncInputOperationService;
import ru.netology.Alex_Zadevalov.service.CustomerService;
import ru.netology.Alex_Zadevalov.service.StatementService;

@Configuration
public class AppConfiguration {
    @Bean
    public StatementService statementService() {
        return new StatementService();
    }

    @Bean
    public CustomerService customerService() {
        return new CustomerService();
    }

    @Bean
    public AsyncInputOperationService asyncInputOperationService() {
        return new AsyncInputOperationService(statementService());
    }

}

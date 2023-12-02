package ru.netology.Alex_Zadevalov;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.netology.Alex_Zadevalov.configuration.AppConfiguration;
import ru.netology.Alex_Zadevalov.domain.operation.Currency;
import ru.netology.Alex_Zadevalov.domain.operation.OperationCreditType;
import ru.netology.Alex_Zadevalov.domain.operation.Operations;
import ru.netology.Alex_Zadevalov.service.AsyncInputOperationService;
import ru.netology.Alex_Zadevalov.service.CustomerService;
import ru.netology.Alex_Zadevalov.service.StatementService;

public class Main {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
        StatementService statementService = applicationContext.getBean(StatementService.class);
        CustomerService customerService = applicationContext.getBean(CustomerService.class);
        AsyncInputOperationService asyncInputOperationService = applicationContext.getBean(AsyncInputOperationService.class);

        customerService.addCustomer(0, "Bill");
        customerService.addCustomer(1, "John");
        statementService.saveOperations(new Operations(OperationCreditType.CREDIT, 50, Currency.RUB, "Cafe", 0));
        statementService.saveOperations(new Operations(OperationCreditType.CREDIT, 3, Currency.USD, "Cafe", 1));



        try {
            asyncInputOperationService.addOperation(new Operations(OperationCreditType.CREDIT, 50, Currency.RUB, "Cafe", 0));
            asyncInputOperationService.addOperation(new Operations(OperationCreditType.CREDIT, 3, Currency.USD, "Cafe", 1));
            Thread.sleep(5_000);
            asyncInputOperationService.startProcessing();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

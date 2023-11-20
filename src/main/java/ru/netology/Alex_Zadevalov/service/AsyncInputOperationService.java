package ru.netology.Alex_Zadevalov.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.Alex_Zadevalov.configuration.OperationProcessingProperties;
import ru.netology.Alex_Zadevalov.domain.operation.Currency;
import ru.netology.Alex_Zadevalov.domain.operation.OperationCreditType;
import ru.netology.Alex_Zadevalov.domain.operation.Operations;
import javax.annotation.PostConstruct;
import java.util.*;

@Component
@AllArgsConstructor
public class AsyncInputOperationService {
    private final Queue<Operations> operations = new LinkedList<>();
    private final StatementService statementService;
    private final OperationProcessingProperties properties;


    @PostConstruct
    public void init(){
        this.startProcessing();
    }

    public void addOperation(OperationCreditType operationCreditType, double sum, Currency currency,
                             String merchant, int customerId){
        Operations operation = new Operations();
        operations.add(operation);
    }

    public void getOperation(int customerId){
        statementService.getOperations();
    }

    public void removeOperation(int operationId){
        statementService.removeOperation(operationId);
    }

    public Queue<Operations> getOperations(){
        return operations;
    }
    public boolean addOperation(Operations operation){
        System.out.println("Operation added for processing " + operation);
        return operations.offer(operation);
    }

    public void startProcessing(){
        Thread t = new Thread(this::processQueue);
        t.start();
    }

    private void processQueue(){
        while (true){
            Operations operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("No operations");
                    Thread.sleep(properties.getTimeout());
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            else{
                System.out.println("Processing operation " + operation);
                processOperation(operation);
            }
        }
    }
    private void processOperation(Operations operation){
        statementService.saveOperations(operation);
    }
}

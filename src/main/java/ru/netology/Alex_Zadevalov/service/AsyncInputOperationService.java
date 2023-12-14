package ru.netology.Alex_Zadevalov.service;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.Alex_Zadevalov.configuration.OperationProperties;
import ru.netology.Alex_Zadevalov.domain.operation.Operation;

import javax.annotation.PostConstruct;
import java.util.*;

@Component
@RequiredArgsConstructor
public class AsyncInputOperationService {

    @Getter
    private final Queue<Operation> operations = new LinkedList<>();
    private final StatementService statementService;
    private final OperationProperties operationProperties;

    @PostConstruct
    public void init(){
        this.startProcessing();
    }

    public boolean addOperation(Operation operation) {
        System.out.println("Operation added for processing " + operation);
        return operations.offer(operation);
    }

    public void startProcessing() {
        Thread t = new Thread(this::processQueue);
        t.start();
    }

    private void processQueue() {
        while (true) {
            Operation operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("No operations");
                    Thread.sleep(operationProperties.getSleepMilliSeconds());
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Processing operation " + operation);
                processOperation(operation);
            }
        }
    }

    private void processOperation(Operation operation) {
        statementService.saveOperation(operation);
    }
}

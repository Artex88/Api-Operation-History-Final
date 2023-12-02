package ru.netology.Alex_Zadevalov.service;

import ru.netology.Alex_Zadevalov.domain.operation.Operations;

import java.util.*;

public class AsyncInputOperationService {
    private final Queue<Operations> operations = new LinkedList<>();
    private final StatementService statementService;

    public AsyncInputOperationService(StatementService statementService) {
        this.statementService = statementService;
    }

    public boolean addOperation(Operations operation) {
        System.out.println("Operation added for processing " + operation);
        return operations.offer(operation);
    }

    public void startProcessing() {
        Thread t = new Thread() {
            @Override
            public void run() {
                processQueue();

            }
        };
        t.start();
    }

    private void processQueue() {
        while (true) {
            Operations operation = operations.poll();
            if (operation == null) {
                try {
                    System.out.println("No operations");
                    Thread.sleep(1_000);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            } else {
                System.out.println("Processing operation " + operation);
                processOperation(operation);
            }
        }
    }

    private void processOperation(Operations operation) {
        statementService.saveOperations(operation);
    }

    public Queue<Operations> getOperations() {
        return operations;
    }

    public StatementService getStatementService() {
        return statementService;
    }
}

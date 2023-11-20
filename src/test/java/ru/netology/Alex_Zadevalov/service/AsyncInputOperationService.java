package ru.netology.Alex_Zadevalov.service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.Alex_Zadevalov.OperationHistoryApiApplicationTest;
import ru.netology.Alex_Zadevalov.domain.operation.Currency;
import ru.netology.Alex_Zadevalov.domain.operation.Operations;
import java.util.Queue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static ru.netology.Alex_Zadevalov.domain.operation.OperationCreditType.CREDIT;


class AsyncInputOperationTest extends OperationHistoryApiApplicationTest{

    @Autowired
    private AsyncInputOperationService asyncInputOperationService;

    @Test
    public void addOperationTest(){
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        int i = asyncInputOperationService.getOperations().size();
        asyncInputOperationService.addOperation(operation);
        int y = asyncInputOperationService.getOperations().size();
        assertEquals(i+1, y);
    }

    @Test
    public void getOperationTest(){
        Queue<Operations> operations = asyncInputOperationService.getOperations();
        assertEquals("[]", operations.toString());
    }

    @Test
    public void removeOperationTest(){
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        asyncInputOperationService.addOperation(operation);
        int i = asyncInputOperationService.getOperations().size();
        asyncInputOperationService.removeOperation(1);
        int y = asyncInputOperationService.getOperations().size();
        assertEquals(i, y);
    }

    @Test
    public void getOperationsTest(){
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        asyncInputOperationService.addOperation(operation);
        Queue<Operations> operations = asyncInputOperationService.getOperations();
        assertEquals("[Транзакция №0. 1000.0 в Shoko null]", operations.toString());
    }

    @Test
    public void addOperation(){
        Operations operation = new Operations(CREDIT, 1000, Currency.RUB, "Shoko", 1);
        asyncInputOperationService.addOperation(operation);
        assertEquals("[Транзакция №0. 1000.0 в Shoko null]", asyncInputOperationService.getOperations().toString());
    }
}
package ru.netology.Alex_Zadevalov.service;


import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.netology.Alex_Zadevalov.domain.Customer;
import ru.netology.Alex_Zadevalov.domain.operation.Currency;
import ru.netology.Alex_Zadevalov.domain.operation.Operation;
import ru.netology.Alex_Zadevalov.domain.operation.OperationCreditType;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Getter
@AllArgsConstructor
public class StatementService {

    private final Map<Integer, List<Operation>> storage = new HashMap<>();

    @PostConstruct
    public void initStorage() {
        List<Operation> initialList = new ArrayList<>();
        initialList.add(new Operation(OperationCreditType.DEBIT, 2500, Currency.RUB, "OZON", 1));
        storage.put(1,initialList);
    }

    public String getStringStorage(){
        return storage.toString();
    }

    public void saveOperation(Operation operation){
        List<Operation> operations = storage.get(operation.getCustomerId());
        if (operations == null){
            List<Operation> customerOperations = new ArrayList<>();
            customerOperations.add(operation);
            storage.put(operation.getCustomerId(), customerOperations);
        } else {
            operations.add(operation);
        }
    }
    public void removeOperation(int operationId){
        storage.remove(operationId);
    }

    public List<Operation> getOperationOnId(int operationId){
        return storage.get(operationId);
    }

    public void removeOperationsOnCustomerId(int id){
        for(int i: storage.keySet()){
            if (i == id){
                storage.remove(i);
            }
        }
    }
}

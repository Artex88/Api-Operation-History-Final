package ru.netology.Alex_Zadevalov.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import ru.netology.Alex_Zadevalov.domain.operation.Operations;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
@AllArgsConstructor
public class StatementService {
    public final Map<Integer, List<Operations>> storage = new HashMap<>();

    public void saveOperations(Operations operation){
        List<Operations> operations = storage.get(operation.getCustomerId());
        if (operations == null){
            List<Operations> customerOperations = new ArrayList<>();
            customerOperations.add(operation);
            storage.put(operation.getCustomerId(), customerOperations);
        } else {
            operations.add(operation);
        }
    }
    public void removeOperation(int operationId){
        storage.remove(operationId);
    }

    public String getOperations(){
        return storage.toString();
    }
}

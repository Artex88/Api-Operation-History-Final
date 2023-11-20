package ru.netology.Alex_Zadevalov.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.Alex_Zadevalov.controller.dto.GetOperationsResponse;
import ru.netology.Alex_Zadevalov.controller.dto.OperationsDTO;
import ru.netology.Alex_Zadevalov.domain.operation.Operations;
import ru.netology.Alex_Zadevalov.service.AsyncInputOperationService;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/operations")
public class OperationController {

    private final AsyncInputOperationService asyncInputOperationService;


    @GetMapping
    public GetOperationsResponse getInputOperations() {
        Queue<Operations> operations = asyncInputOperationService.getOperations();
        List<OperationsDTO> operationDTOS = new ArrayList<>();
        for (Operations operation : operations) {
            OperationsDTO operationDTO = new OperationsDTO(operation.getOperationCreditType(),
                    operation.getSum(), operation.getCurrency(),operation.getMerchant(), operation.getCustomerId());
            operationDTOS.add(operationDTO);
        }
        return new GetOperationsResponse(operationDTOS);
    }


    @GetMapping("/{customerId}")
    public OperationsDTO getOperation(@PathVariable int customerId) {
        for (Operations operation : asyncInputOperationService.getOperations()) {
            if (operation.getCustomerId() == customerId) {
                OperationsDTO operationsDTO = new OperationsDTO(operation.getOperationCreditType(),
                        operation.getSum(), operation.getCurrency(), operation.getMerchant(), operation.getCustomerId());
                return operationsDTO;
            }
        }
        return null;
    }

   @PostMapping("/{customerId}")
   public void addOperation(@RequestBody Operations operation) {
       asyncInputOperationService.addOperation(operation.getOperationCreditType(),
               operation.getSum(), operation.getCurrency(), operation.getMerchant(), operation.getCustomerId());
   }

    @PostMapping("/{operationId}/remove")
    public void removeOperation(@RequestBody int operationId) {
        asyncInputOperationService.removeOperation(operationId);
    }

}

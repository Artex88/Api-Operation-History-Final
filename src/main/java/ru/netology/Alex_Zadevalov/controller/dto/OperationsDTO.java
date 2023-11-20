package ru.netology.Alex_Zadevalov.controller.dto;

import lombok.Data;
import ru.netology.Alex_Zadevalov.domain.operation.Currency;
import ru.netology.Alex_Zadevalov.domain.operation.OperationCreditType;

@Data
public class OperationsDTO {
    private final OperationCreditType operationCreditType;
    private final double sum;
    private final Currency currency;
    private final String merchant;
    private final int customerId;

}

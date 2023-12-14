package ru.netology.Alex_Zadevalov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import ru.netology.Alex_Zadevalov.domain.operation.Currency;
import ru.netology.Alex_Zadevalov.domain.operation.OperationCreditType;

@Data
@AllArgsConstructor
public class OperationDTO {
    private final int customerId;
    private final double sum;
    private final Currency currency;
    private final String merchant;
    private final OperationCreditType operationCreditType;
}

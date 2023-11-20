
package ru.netology.Alex_Zadevalov.domain.operation;

import lombok.*;
import ru.netology.Alex_Zadevalov.domain.ConsolePrintable;


@Getter
@Setter
@AllArgsConstructor
public class Operations extends BaseOperation implements ConsolePrintable {
    private OperationCreditType operationCreditType;
    private double sum;
    private Currency currency;
    private String merchant;
    private int customerId;

    public Operations(){

    }

    public void printToConsole(){
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Транзакция №" + getId() + ". " + getSum() +  " в " + getMerchant() + " " + getTime();
    }
}


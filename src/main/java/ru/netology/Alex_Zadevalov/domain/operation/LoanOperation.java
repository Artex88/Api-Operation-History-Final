package ru.netology.Alex_Zadevalov.domain.operation;

import lombok.*;
import ru.netology.Alex_Zadevalov.domain.ConsolePrintable;

@Getter
@Setter
@AllArgsConstructor

public class LoanOperation extends Operations implements ConsolePrintable {
    private int loanId;

    @Override
    public void printToConsole(){
        super.printToConsole();
        System.out.println("Loan Id " + loanId);
    }

}

package ru.netology.Alex_Zadevalov.domain.operation;

import ru.netology.Alex_Zadevalov.domain.ConsolePrintable;

public class AuthOperation extends BaseOperation implements ConsolePrintable {
    private String ip;

    @Override
    public void printToConsole() {
        System.out.println();
    }
}

package ru.netology.Alex_Zadevalov.domain.operation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseOperation {
    private int id;
    private LocalDateTime time;

    public abstract void printToConsole();

}

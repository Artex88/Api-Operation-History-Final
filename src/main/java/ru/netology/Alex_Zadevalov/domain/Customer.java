package ru.netology.Alex_Zadevalov.domain;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Customer implements ConsolePrintable{
    private int Id;
    private String name;

    public void printToConsole() {
        System.out.println(getId() + name);
    }
}
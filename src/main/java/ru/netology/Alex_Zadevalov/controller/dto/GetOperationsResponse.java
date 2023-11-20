package ru.netology.Alex_Zadevalov.controller.dto;

import lombok.Data;

import java.util.List;
@Data
public class GetOperationsResponse {
    private final List<OperationsDTO> operationDTOS;
}

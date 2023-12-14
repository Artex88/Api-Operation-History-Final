package ru.netology.Alex_Zadevalov.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class OperationsGetResponse {
    private final List<OperationDTO> operations;

}

package ru.netology.Alex_Zadevalov.controller.dto;

import lombok.Data;
import java.util.List;

@Data
public class GetCustomersResponse {
    private final List<CustomersDTO> Customers;
}

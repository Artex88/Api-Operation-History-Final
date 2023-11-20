package ru.netology.Alex_Zadevalov.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.netology.Alex_Zadevalov.controller.dto.CustomersDTO;
import ru.netology.Alex_Zadevalov.controller.dto.GetCustomersResponse;
import ru.netology.Alex_Zadevalov.domain.Customer;
import ru.netology.Alex_Zadevalov.service.CustomerService;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/customers")
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping
    public GetCustomersResponse getCustomers(){
        List<Customer> customers = customerService.getCustomers();
        List<CustomersDTO> customerDTOS = new ArrayList<>();
        for (Customer customer: customers) {
            CustomersDTO customerDTO = new CustomersDTO(customer.getId(), customer.getName());
            customerDTOS.add(customerDTO);
        }
        return new GetCustomersResponse(customerDTOS);
    }


    @GetMapping("/{customerId}")
    public CustomersDTO getCustomer(@PathVariable int customerId){
        for (Customer customer: customerService.getCustomers()) {
            if (customer.getId() == customerId){
                CustomersDTO customersDTO = new CustomersDTO(customer.getId(), customer.getName());
                return customersDTO;
            }
        }
        return null;
    }

    @PostMapping("/{customerId}")
    public void addCustomer(@RequestBody  Customer customer){
        customerService.addCustomer(customer.getId(), customer.getName());
    }
}
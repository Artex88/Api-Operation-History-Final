package ru.netology.Alex_Zadevalov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.netology.Alex_Zadevalov.domain.Customer;
import ru.netology.Alex_Zadevalov.dto.CustomerDTO;
import ru.netology.Alex_Zadevalov.dto.CustomersGetResponse;
import ru.netology.Alex_Zadevalov.service.CustomerService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/api/customers/")
public class CustomerController {
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public CustomersGetResponse getCustomers(){
        List<Customer> customers = customerService.getStorage();
        List<CustomerDTO> customerDTOS = new ArrayList<>();
        for (Customer customer : customers) {
            CustomerDTO customerDTO = new CustomerDTO(customer.getId(), customer.getName());
            customerDTOS.add(customerDTO);
        }
        return new CustomersGetResponse(customerDTOS);
    }

    @GetMapping("{customersId}")
    public CustomerDTO getCustomer(@PathVariable("customersId") int customersId){
        Customer customer = customerService.getCustomer(customersId);
        return new CustomerDTO(customer.getId(), customer.getName());
    }
    @PostMapping
    public CustomerDTO addCustomer(int id, String name){
        customerService.addCustomer(id, name);
        Customer customer = customerService.getCustomer(id);
        return new CustomerDTO(customer.getId(),customer.getName());
    }
}

package ru.netology.Alex_Zadevalov.service;

import lombok.Getter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.netology.Alex_Zadevalov.domain.Customer;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Getter
@Service
public class CustomerService {

    private final List<Customer> storage;

    @PostConstruct
    public void initStorage() {
        storage.add(new Customer(0, "Spring"));
        storage.add(new Customer(1, "Boot"));
    }

    public CustomerService(List<Customer> storage) {
        this.storage = storage;
    }

    public void addCustomer(int id, String name) {
        Customer customer = new Customer(id, name);
        storage.add(customer);
    }

    public Customer getCustomer(int customerId) {
        return storage.get(customerId);
    }

}
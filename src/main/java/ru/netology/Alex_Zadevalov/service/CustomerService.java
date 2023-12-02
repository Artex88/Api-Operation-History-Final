package ru.netology.Alex_Zadevalov.service;

import ru.netology.Alex_Zadevalov.domain.Customer;
import java.util.ArrayList;
import java.util.List;


public class CustomerService {
    private final List<Customer> storage = new ArrayList<>();

    public void addCustomer(int id, String name) {
        Customer customer = new Customer(id, name);
        storage.add(customer);
    }

    public List<Customer> getCustomers() {
        return storage;
    }

    public CustomerService() {
    }

    public List<Customer> getStorage() {
        return storage;
    }

}
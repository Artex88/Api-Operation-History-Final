package ru.netology.Alex_Zadevalov.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.netology.Alex_Zadevalov.OperationHistoryApiApplicationTest;
import ru.netology.Alex_Zadevalov.controller.dto.CustomersDTO;
import ru.netology.Alex_Zadevalov.controller.dto.GetCustomersResponse;
import ru.netology.Alex_Zadevalov.domain.Customer;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class CustomerControllerTest extends OperationHistoryApiApplicationTest {
    @Autowired
    private CustomerController customerController;

    @Test
    public void getCustomersTest(){
        GetCustomersResponse customers = customerController.getCustomers();
        CustomersDTO customer1 = customers.getCustomers().get(0);
        CustomersDTO customer2 = customers.getCustomers().get(1);

        assertEquals(1, customer1.getId());
        assertEquals("Nikita", customer1.getName());
        assertEquals(2, customer2.getId());
        assertEquals("Oleg", customer2.getName());
    }

    @Test
    public void getCustomerTest(){
        CustomersDTO customerDTO1 = customerController.getCustomer(10);
        assertNull(customerDTO1);
    }

    @Test
    public void addCustomerTest(){
        Customer customer1 = new Customer(5, "TestName") ;
        customerController.addCustomer(customer1);
        assertEquals(5, customer1.getId());
        assertEquals("TestName", customer1.getName());
    }
}
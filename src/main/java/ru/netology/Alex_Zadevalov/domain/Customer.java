package ru.netology.Alex_Zadevalov.domain;



import java.util.Objects;


public class Customer implements ConsolePrintable{
    private int Id;
    private String name;

    public void printToConsole() {
        System.out.println(getId() + name);
    }

    public Customer(int id, String name) {
        Id = id;
        this.name = name;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (Id != customer.Id) return false;
        return Objects.equals(name, customer.name);
    }

    @Override
    public int hashCode() {
        int result = Id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                '}';
    }
}
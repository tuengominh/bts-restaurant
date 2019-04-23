package tech.bts.mobiledevjava.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private String name;
    private List<Order> orders;

    public Customer(String name) {
        this.name = name;
        this.orders = new ArrayList<Order>();
    }

    //add an order to customer's purchase records
    public void addOrder(Order order) {
        this.orders.add(order);
    }

    //get a List of all orders from the same customer
    public List<Order> getAllOrders() {
        return orders;
    }

    public String getName() { return name; }

    @Override
    public String toString() {
        return this.name + " has ordered " + this.orders.size() + " times at our restaurant.";
    }
}

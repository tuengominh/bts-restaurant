package tech.bts.restaurant.model;

public class Order {

    private String customerName;
    private BaseDish customerDish;

    //empty constructor
    public Order() {}

    //constructor with only customer name
    public Order(String customerName) {
        this.customerName = customerName;
    }

    //constructor with all parameters
    public Order(String customerName, BaseDish customerDish) {
        this.customerName = customerName;
        this.customerDish = customerDish;
    }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public BaseDish getCustomerDish() { return customerDish; }

    public void setCustomerDish(BaseDish customerDish) { this.customerDish = customerDish; }

    //get the Order object
    public Order getOrder() { return this; }

    @Override
    public String toString() {
        return customerName + " has ordered: " + customerDish.toString();
    }
}

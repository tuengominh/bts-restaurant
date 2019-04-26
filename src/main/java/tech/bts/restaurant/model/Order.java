package tech.bts.restaurant.model;

import java.util.Arrays;
import java.util.List;

public class Order {

    private String customerName;
    private Starter starter;
    private MainCourse mainCourse;
    private Dessert dessert;

    //empty constructor
    public Order() {}

    //constructor with only customer name
    public Order(String customerName) {
        this.customerName = customerName;
    }

    //constructor with all parameters
    public Order(String customerName, Starter starter, MainCourse mainCourse, Dessert dessert) {
        this.customerName = customerName;
        this.starter = starter;
        this.mainCourse = mainCourse;
        this.dessert = dessert;
    }

    //get a List of all dishes from the order
    public List<Dish> getAllDishes() { return Arrays.asList(starter, mainCourse, dessert); }

    public String getCustomerName() { return customerName; }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    //get the Order object
    public Order getOrder() { return this; }

    public Starter getStarter() { return starter; }

    public void setStarter(Dish starter) {
        this.starter = (Starter) starter;
    }

    public MainCourse getMainCourse() { return mainCourse; }

    public void setMainCourse(Dish mainCourse) {
        this.mainCourse = (MainCourse) mainCourse;
    }

    public Dessert getDessert() { return dessert; }

    public void setDessert(Dish dessert) {
        this.dessert = (Dessert) dessert;
    }

    @Override
    public String toString() {
        String result = "This order of " + customerName + " includes these dishes:\n";
        if(starter != null) {
            result += starter.toString() + "\n";
        }
        if(mainCourse != null) {
            result += mainCourse.toString() + "\n";
        }
        if(dessert != null) {
            result += dessert.toString() + "\n";
        }
        return result;
    }
}

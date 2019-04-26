package tech.bts.restaurant.model;

import tech.bts.restaurant.exception.CannotProceedOrderException;

import java.util.Arrays;
import java.util.List;

import static tech.bts.restaurant.model.Dish.Type.ds;
import static tech.bts.restaurant.model.Dish.Type.mc;
import static tech.bts.restaurant.model.Dish.Type.st;

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

    //add a single dish to the order
    public void addDishToOrder(Dish dish){
        if (dish.getDishType() == st && this.starter != null) {
            add(starter, dish);
            System.out.println("Starter: " + starter.getDishName() + " added.");
        } else if (dish.getDishType() == mc && this.mainCourse != null) {
            add(mainCourse, dish);
            System.out.println("Main course: " + mainCourse.getDishName() + " added.");
        } else if (dish.getDishType() == ds && this.dessert != null) {
            add(dessert, dish);
            System.out.println("Dessert: " + dessert.getDishName() + " added.");
        } else {
            throw new CannotProceedOrderException();
        }
    }

    public void add(Dish orderItem, Dish dish){
        orderItem.setDishName(dish.getDishName());
        orderItem.setDishType(dish.getDishType());
        orderItem.setGlutenFree(dish.isGlutenFree());
        orderItem.setHalalMeat(dish.isHalalMeat());
        orderItem.setVegetarian(dish.isVegetarian());
        orderItem.setSeafoodFree(dish.isSeafoodFree());
        orderItem.setExtras(dish.getExtras());
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

    public void setStarter(Starter starter) {
        this.starter = starter;
    }

    public MainCourse getMainCourse() { return mainCourse; }

    public void setMainCourse(MainCourse mainCourse) {
        this.mainCourse = mainCourse;
    }

    public Dessert getDessert() { return dessert; }

    public void setDessert(Dessert dessert) {
        this.dessert = dessert;
    }

    /**@Override
    public String toString() {
        return "This order of " + customerName + " includes these dishes:\n" + starter.toString() + "\n" + mainCourse.toString() + "\n" + dessert.toString();
    }*/
}

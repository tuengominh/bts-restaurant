package tech.bts.restaurant;

import tech.bts.restaurant.model.*;
import tech.bts.restaurant.service.SalesService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainApplication {
    public static void main(String[] args) throws Exception {

        /**Print required information by reading CSV file*/

        SalesService salesService = new SalesService();
        List<Order> orders = salesService.readOrders("src/main/resources/online-order-sample.csv");
        List<Dish> dishes = new ArrayList<Dish>();
        for (Order order : orders) {
            for (Dish dish : order.getAllDishes()) {
                dishes.add(dish);
            }
        }

        System.out.println("Welcome to Tue's restaurant!");
        System.out.println("\n#Number of orders:" + salesService.getNumberOrders(orders));
        System.out.println("\n#All orders:\n" + salesService.getAllOrdersToString(orders));
        System.out.println("\n#The last order:\n" + salesService.getOrder(orders,orders.size()-1));

        System.out.println("\n#All dishes:\n" + salesService.getAllDishToString(dishes));
        System.out.println("\n#The first dish ordered:\n" + salesService.getDish(dishes,0));

        System.out.println("\n#All starters ordered:\n" + salesService.getDishesByType(dishes, "st"));
        System.out.println("\n#All vegetarian dishes:\n" + salesService.getDishesByCategory(dishes, "vgd"));

        System.out.println("\n#" + salesService.getStatsByCategory(dishes, "gfd") + "\n");
        System.out.println("\n#" + salesService.getStatsByCategoryAndCustomer(orders,"Tue Ngo", "gfd") + "\n");

        /**Read inputs from users and add records to CSV file*/

        Scanner scanner = new Scanner(System.in);
        List<Order> orderList = new ArrayList<Order>();
        Order order = new Order();

        System.out.println("Your name: ");
        order.setCustomerName(scanner.nextLine());

        //For now dummy data is loaded. In the future a menu.csv file can be used to store data
        Menu menu = new Menu();
        menu.addDish(new Starter("Tomato Soup", true, true, false, true, "Spoon"));
        menu.addDish(new Starter("Mushroom Pasta", false, false, false, true, "Fork"));
        menu.addDish(new Starter("Green Salad", true, true, false, false, "Fork"));

        menu.addDish(new MainCourse("Beefsteak with Mushroom Sauce", false, false, false, true, "Beef-Red wine"));
        menu.addDish(new MainCourse("Vegetables Wok", true, true, false, true, "Vegetables-Tea"));
        menu.addDish(new MainCourse("Grilled Cod Fish", false, false, false, false, "White fish-Champagne"));

        menu.addDish(new Dessert("Mango Ice-cream", false, true, false, true, "120"));
        menu.addDish(new Dessert("Brownie Cake", false, false, false, true, "220"));
        menu.addDish(new Dessert("Orange Carpaccio", true, true, false, true, "60"));

        System.out.println("Choose your starter: ");
        for (Dish dish : menu.getAllStarters()) {
            System.out.println(dish.toString());
        }
        //can be developed as select() method in the future
            for (Dish dish : menu.getAllDishes()){
                if(dish.getDishName().contains(scanner.nextLine())){
                    order.addDishToOrder(dish);
                }
            }

        System.out.println("Choose your main course: ");
        for (Dish dish : menu.getAllMainCourses()) {
            System.out.println(dish.toString());
        }
        for (Dish dish : menu.getAllDishes()){
            if(dish.getDishName().contains(scanner.nextLine())){
                order.addDishToOrder(dish);
            }
        }

        System.out.println("Choose your dessert: ");
        for (Dish dish : menu.getAllDesserts()) {
            System.out.println(dish.toString());
        }
        for (Dish dish : menu.getAllDishes()){
            if(dish.getDishName().contains(scanner.nextLine())){
                order.addDishToOrder(dish);
            }
        }

        orderList.add(order);
        salesService.writeOrders(orderList,"src/main/resources/online-order-sample.csv");
    }
}

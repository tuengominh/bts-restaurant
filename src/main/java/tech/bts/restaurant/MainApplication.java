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
        List orders = salesService.readOrders("src/main/resources/online-order-sample.csv");

        System.out.println("Welcome to Tue's restaurant!" + "\n");
        System.out.println("# Number of orders: " + salesService.getNumberOrders(orders) + "\n");
        System.out.println("# All orders:\n" + salesService.getAllOrdersToString(orders));
        System.out.println("# The last order:\n" + salesService.getOrder(orders,orders.size()-1));

        List dishes = new ArrayList<Object>();
        for (Object order : orders) {
            for (BaseDish baseDish : ((Order) order).getAllDishes()) {
                dishes.add(baseDish);
            }
        }

        System.out.println("# All dishes:\n" + salesService.getAllDishToString(dishes));
        System.out.println("# The first dish ordered:\n" + salesService.getDish(dishes,0));

        System.out.println("\n# All starters ordered:");
        for (Object dish : salesService.getDishesByType(dishes, "st")) {
            System.out.println(dish.toString());
        }

        System.out.println("\n# All vegetarian dishes:");
        for (Object dish : salesService.getDishesByCategory(dishes, "vgd")) {
            System.out.println(dish.toString());
        }

        System.out.println("\n# All dishes by Tue Ngo:");
        for (Object dish : salesService.getDishesByCustomer(orders, "Tue Ngo")) {
            System.out.println(dish.toString());
        }

        System.out.println("\n# " + salesService.getStatsByCategory(dishes, "gfd"));
        System.out.println("\n# " + salesService.getStatsByCategoryAndCustomer(orders,"Eole Cervenka", "gfd") + "\n");

        /**Read inputs from users and add records to CSV file*/

        Scanner scanner = new Scanner(System.in);
        List<Order> orderList = new ArrayList<Order>();
        Order order = new Order();

        System.out.println("# Your name: ");
        order.setCustomerName(scanner.nextLine());

        //For now dummy data is loaded. In the future a menu.csv file can be used to store data
        Menu menu = new Menu();
        menu.addDish(new Starter("Tomato Soup", true, true, false, true, "Spoon"));
        menu.addDish(new MainCourse("Beefsteak with Mushroom Sauce", false, false, false, true, "Beef-Red wine"));
        menu.addDish(new Dessert("Orange Carpaccio", true, true, false, true, "60"));

        System.out.println("# Choose your dish: ");
        System.out.println(menu.toString());

        for (BaseDish baseDish : menu.getAllDishes()) {
            if(baseDish.getDishName().contains(scanner.nextLine())){
                if(baseDish.getClass().getName().equals("Starter")){
                    order.setStarter(baseDish);
                } else if(baseDish.getClass().getName().equals("MainCourse")){
                    order.setMainCourse(baseDish);
                } else if(baseDish.getClass().getName().equals("Dessert")){
                    order.setDessert(baseDish);
                }
            }
        }
        orderList.add(order);
        salesService.writeOrders(orderList,"src/main/resources/online-order-sample.csv");
    }
}

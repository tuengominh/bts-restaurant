package tech.bts.mobiledevjava.service;

import tech.bts.mobiledevjava.model.Customer;
import tech.bts.mobiledevjava.model.Dish;
import tech.bts.mobiledevjava.model.Order;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class SalesService implements OnlineOrderOps {

    //TODO: read & write CSV

    public int getNumberOrders(List orders) {
        return orders.size();
    }

    public Object getOrder(List orders, int orderId) {
        return orders.get(orderId);
    }

    public String getAllOrdersToString(List orders) {
        String result = "";
        for (Object order : orders) {
            result += order.toString() + "\n";
        }
        return result;
    }

    public Dish getDish(List dishes, int dishId) {
        return (Dish) dishes.get(dishId);
    }

    public String getAllDishToString(List dishes) {
        String result = "";
        for (Object dish : dishes) {
            result += dish.toString() + "\n";
        }
        return result;
    }

    public List getDishesByType(List dishes, String dishType) {
        List<Object> result = new ArrayList<Object>();
        for (Object dish : dishes) {
            String typeName = valueOf(((Dish) dish).getDishType());
            if (typeName.equals(dishType)) {
                result.add(dish);
            }
        }
        return result;
    }

    public List getDishesByCategory(List dishes, String category) {
        List<Object> result = new ArrayList<Object>();
        for (Object dish : dishes) {
            if (((Dish) dish).isGlutenFree() && category.equals("gfd")) {
                result.add(dish);
            } else if (((Dish) dish).isVegetarian() && category.equals("vgd")) {
                result.add(dish);
            } else if (((Dish) dish).isHalalMeat() && category.equals("hmd")) {
                result.add(dish);
            } else if (((Dish) dish).isSeafoodFree() && category.equals("sfd")) {
                result.add(dish);
            }
        }
        return result;
    }

    public double getStatsByCategory(List dishes, String category) {
        List<Object> dishesByCategory = getDishesByCategory(dishes, category);
        double stats = (dishesByCategory.size()/dishes.size()) * 100;
        System.out.println(stats + "% of orders are " + category);
        return stats;
    }

    public double getStatsByCategoryAndCustomer(List dishes, Customer customer, String category) {
        List<Object> orderedDishesByCategory = getDishesByCategory(getDishesByCustomer(customer), category);
        double stats = orderedDishesByCategory.size() / customer.getAllOrders().size() * 100;
        System.out.println(stats + "% of orders from " + customer.getName() + " are " + category);
        return stats;
    }

    public List<Object> getDishesByCustomer(Customer customer) {
        List<Object> dishesByCustomer = new ArrayList<Object>();
        for (Order order : customer.getAllOrders()) {
            for (Dish dish : order.getAllDishes()) {
                dishesByCustomer.add(dish);
            }
        }
        return dishesByCustomer;
    }
}

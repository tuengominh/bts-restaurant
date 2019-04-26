package tech.bts.restaurant.service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.CSVWriter;
import tech.bts.restaurant.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.valueOf;

public class SalesService implements OnlineOrderOps {

    //read sample CSV file and parse to Order objects
    public List<Order> readOrders(String path) throws Exception {
        List<Order> orders = new ArrayList<Order>();

        BufferedReader reader = new BufferedReader(new FileReader(path));
        CSVReader csvReader = new CSVReaderBuilder(reader).withSkipLines(1).build();
        List<String[]> records = csvReader.readAll();

        for (String[] record : records) {
            Order order = new Order(record[0]);
            if (record[2].equals("st")) {
                Starter dish = new Starter(record[1]);
                addRecordDetails(dish, record);
                order.setStarter(dish);
            } else if (record[2].equals("mc")) {
                MainCourse dish = new MainCourse(record[1]);
                addRecordDetails(dish, record);
                order.setMainCourse(dish);
            } else if (record[2].equals("ds")) {
                Dessert dish = new Dessert(record[1]);
                addRecordDetails(dish, record);
                order.setDessert(dish);
            }
            orders.add(order);
        }
        return orders;
    }

    public void addRecordDetails(Dish dish, String[] record) {
        dish.setGlutenFree(Boolean.parseBoolean(record[3]));
        dish.setVegetarian(Boolean.parseBoolean(record[4]));
        dish.setHalalMeat(Boolean.parseBoolean(record[5]));
        dish.setSeafoodFree(Boolean.parseBoolean(record[6]));
        dish.setExtras(record[7]);
    }

    // update new order to CSV file
    public void writeOrders(List<Order> orders, String path) throws Exception {
        CSVWriter writer = new CSVWriter(new FileWriter(path, true));
        for (Order order : orders) {
            String data = order.getCustomerName() + ",";
            for (Dish dish : order.getAllDishes()) {
                data += dish.getDishName() + ","
                        + dish.getDishType() + ","
                        + dish.isGlutenFree() + ","
                        + dish.isVegetarian() + ","
                        + dish.isHalalMeat() + ","
                        + dish.isSeafoodFree() + ","
                        + dish.getExtras();
            }
            String [] record = data.split(",");
            writer.writeNext(record);
        }
        writer.close();
        System.out.println("Order has been added.");
    }

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
            if (dish != null) {
                result += dish.toString() + "\n";
            }
        }
        return result;
    }

    public List getDishesByType(List dishes, String dishType) {
        List<Object> result = new ArrayList<Object>();
        for (Object dish : dishes) {
            if (dish != null) {
                String typeName = valueOf(((Dish) dish).getDishType());
                if (typeName.equals(dishType)) {
                    result.add(dish);
                }
            }
        }
        return result;
    }

    public List getDishesByCategory(List dishes, String category) {
        List<Object> result = new ArrayList<Object>();
        for (Object dish : dishes) {
            if (dish != null) {
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
        }
        return result;
    }

    public String getStatsByCategory(List dishes, String category) {
        List<Object> dishesByCategory = getDishesByCategory(dishes, category);
        double stats = (dishesByCategory.size()/dishes.size()) * 100;
        return stats + "% of orders are " + category;
    }

    public String getStatsByCategoryAndCustomer(List orders, String customerName, String category) {
        List<Object> orderedDishesByCategory = getDishesByCategory(getDishesByCustomer(orders, customerName), category);
        double stats = (orderedDishesByCategory.size()/getDishesByCustomer(orders, customerName).size()) * 100;
        return stats + "% of orders from " + customerName + " are " + category;
    }

    public List<Object> getDishesByCustomer(List<Order> orders, String customerName){
        List<Object> dishesByCustomer = new ArrayList<Object>();
        for (Object order : orders) {
            if (((Order) order).getCustomerName().equals(customerName)) {
                dishesByCustomer.add(order);
            }
        }
        return dishesByCustomer;
    }
}

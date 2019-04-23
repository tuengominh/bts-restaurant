package tech.bts.mobiledevjava.service;

import tech.bts.mobiledevjava.model.Customer;
import tech.bts.mobiledevjava.model.Dish;

import java.util.List;

public interface OnlineOrderOps<T, S extends Dish>  {
    /**'OnlineOrderOps' is an interface designed by the system administrator.
     * The aim is to indicate the developer (you, in this case)
     * in which way the on-line order data should be accessed/treated/employed within the application.
     * This interface MUST be implemented by at least one class of your code.*/

    // retrieves the number of orders from the List input argument
    int getNumberOrders(List<T> orders);

    // returns one single order taking an index (referring to a List, for instance) as input argument
    T getOrder(List<T> orders, int orderId);

    // retrieves a String describing every order included in a List used as input argument
    String getAllOrdersToString(List<T> orders);

    // returns one singular dish taking an index (referring to a List, for instance) as input argument
    S getDish(List<S> dishes, int dishId);

    // retrieves a String outlining all the dish names included in a List.
    String getAllDishToString(List<S> dishes);

    // retrieves a List of Dish-related objects corresponding to those dishes which match the type 'dishType' (st, mc, or ds) used as input argument
    List<S> getDishesByType(List<S> dishes, String dishType);

    // returns a List of Dish-related objects including those dishes which match a category (gfd, vgd, hmd, or sfd) used as input argument
    List<S> getDishesByCategory(List<S> dishes, String category);

    // returns the percentage of dishes ordered which match a category (gfd, vgd, hmd, or sfd) used as input argument
    double getStatsByCategory(List<S> dishes, String category);

    // returns the percentage of dishes ordered which match a category (gfd, vgd, hmd, or sfd) and customer used as input argument
    double getStatsByCategoryAndCustomer(List<S> dishes, Customer customer, String category);
}

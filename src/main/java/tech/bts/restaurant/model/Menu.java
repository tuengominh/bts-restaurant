package tech.bts.restaurant.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<BaseDish> dishes;

    public Menu() {
        this.dishes = new ArrayList<BaseDish>();
    }

    //getters
    public List<BaseDish> getDishes() { return dishes; }

    //later can be developed into a MenuService/MenuManager class
    public void addDish(BaseDish dish) {
        this.dishes.add(dish);
    }

    public List<BaseDish> getAllDishes() {
        List<BaseDish> result = new ArrayList<BaseDish>();
        for (int i = 0; i < dishes.size(); i++) {
            result.add(dishes.get(i));
        }
        return result;
    }

    @Override
    public String toString() {
        String result = "Dishes in Menu:\n";
        for (BaseDish dish : dishes) {
            result += dish.getDishName() + "\n";
        }
        return result;
    }
}

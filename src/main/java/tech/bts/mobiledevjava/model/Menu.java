package tech.bts.mobiledevjava.model;

import java.util.ArrayList;
import java.util.List;

public class Menu {

    private List<Dish> starters;
    private List<Dish> mainCourses;
    private List<Dish> desserts;

    public Menu() {
        this.starters = new ArrayList<Dish>();
        this.mainCourses = new ArrayList<Dish>();
        this.desserts = new ArrayList<Dish>();
    }

    public void addDish(Dish dish) {
        if (dish.getDishType() == Dish.Type.st) {
            this.starters.add(dish);
        } else if (dish.getDishType() == Dish.Type.mc) {
            this.mainCourses.add(dish);
        } else if (dish.getDishType() == Dish.Type.ds) {
            this.desserts.add(dish);
        }
    }

    //getters
    public List<Dish> getAllStarters() {
        return starters;
    }
    public List<Dish> getAllMainCourses() {
        return mainCourses;
    }
    public List<Dish> getAllDesserts() {
        return desserts;
    }

    public List<Dish> getAllDishes() {
        List<Dish> result = new ArrayList<Dish>();
        for (int i = 0; i < starters.size(); i++) {
            result.add(starters.get(i));
        }
        for (int i = 0; i < mainCourses.size(); i++) {
            result.add(mainCourses.get(i));
        }
        for (int i = 0; i < desserts.size(); i++) {
            result.add(desserts.get(i));
        }
        return result;
    }
}

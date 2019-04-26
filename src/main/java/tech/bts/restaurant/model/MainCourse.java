package tech.bts.restaurant.model;

public class MainCourse extends Dish {

    public MainCourse(String dishName, boolean glutenFree, boolean vegetarian, boolean halalMeat, boolean seafoodFree, String extras) {
        super(dishName, glutenFree, vegetarian, halalMeat, seafoodFree, extras);
        this.setDishType(Type.mc);
    }

    //allow dishes with unspecified category
    public MainCourse(String dishName) {
        super(dishName);
        this.setDishType(Type.mc);
    }

    @Override
    public String toString() {
        return super.toString() +", main ingredients: " + extras.split("-")[0] + ", paired with: " + extras.split("-")[1];
    }
}

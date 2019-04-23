package tech.bts.mobiledevjava.model;

public class Starter extends Dish {

    public Starter(String dishName, boolean glutenFree, boolean vegetarian, boolean halalMeat, boolean seafoodFree, String extras) {
        super(dishName, glutenFree, vegetarian, halalMeat, seafoodFree, extras);
        this.setDishType(Type.st);
    }

    //allow dishes with unspecified category
    public Starter(String dishName) {
        super(dishName);
        this.setDishType(Type.st);
    }

    @Override
    public String toString() {
        return super.toString() + ", cutlery: " + extras;
    }

}

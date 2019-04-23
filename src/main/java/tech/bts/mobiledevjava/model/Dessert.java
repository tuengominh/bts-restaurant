package tech.bts.mobiledevjava.model;

public class Dessert extends Dish{

    public Dessert(String dishName, boolean glutenFree, boolean vegetarian, boolean halalMeat, boolean seafoodFree, String extras) {
        super(dishName, glutenFree, vegetarian, halalMeat, seafoodFree, extras);
        this.setDishType(Type.ds);
    }

    //allow dishes with unspecified category
    public Dessert(String dishName) {
        super(dishName);
        this.setDishType(Type.ds);
    }

    @Override
    public String toString() {
        return super.toString() + ", contains " + extras + " calories";
    }

}

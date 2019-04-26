package tech.bts.restaurant.model;

public abstract class Dish {

    protected String dishName;
    protected Type dishType;
    protected boolean glutenFree;
    protected boolean vegetarian;
    protected boolean halalMeat;
    protected boolean seafoodFree;
    protected String extras;

    protected enum Type {st, mc, ds}

    //empty constructor
    public Dish() {}

    //allow dishes with unspecified type and category
    public Dish(String dishName) {
        this.dishName = dishName;
    }

    //constructor with all parameters. type will be added in subclasses.
    public Dish(String dishName, boolean glutenFree, boolean vegetarian, boolean halalMeat, boolean seafoodFree, String extras) {
        this.dishName = dishName;
        this.glutenFree = glutenFree;
        this.vegetarian = vegetarian;
        this.halalMeat = halalMeat;
        this.seafoodFree = seafoodFree;
        this.extras = extras;
    }

    //setters & getters
    public String getDishName() { return this.dishName; }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Type getDishType() {
        return this.dishType;
    }

    public void setDishType(Type dishType) {
        this.dishType = dishType;
    }

    public boolean isGlutenFree() {
        return this.glutenFree;
    }

    public void setGlutenFree(boolean glutenFree) {
        this.glutenFree = glutenFree;
    }

    public boolean isVegetarian() {
        return this.vegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public boolean isHalalMeat() {
        return this.halalMeat;
    }

    public void setHalalMeat(boolean halalMeat) { this.halalMeat = halalMeat; }

    public boolean isSeafoodFree() {
        return this.seafoodFree;
    }

    public void setSeafoodFree(boolean seafoodFree) {
        this.seafoodFree = seafoodFree;
    }

    public String getExtras() {
        return this.extras;
    }

    public void setExtras(String extras) { this.extras = extras; }

    //return info: name, type, category. extras will be implemented in subclasses
    @Override
    public String toString() {
        String result = "The dish called: " + this.dishName;

        if (this.dishType == Type.st) {
            result += ", type: starter";
        } else if (this.dishType == Type.mc) {
            result += ", type: main course";
        } else if (this.dishType == Type.ds) {
            result += ", type: dessert";
        } else {
            result += ", unknown type";
        }

        if (this.isGlutenFree()) {
            result += ", gluten-free";
        }
        if (this.isVegetarian()) {
            result += ", vegetarian";
        }
        if (this.isHalalMeat()) {
            result += ", halal meat";
        }
        if (this.isSeafoodFree()) {
            result += ", seafood-free";
        }
        return result;
    }
}


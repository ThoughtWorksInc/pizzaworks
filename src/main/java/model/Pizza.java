package model;

public class Pizza {
    private String name;
    private float price;
    private String ingredients;
    private String slug;
    private NutritionalValues nutritionalValues;


    public Pizza(String name, float price, String ingredients, String slug, NutritionalValues nutritionalValues) {
        this.name = name;
        this.price = price;
        this.ingredients = ingredients;
        this.slug = slug;
        this.nutritionalValues = nutritionalValues;
    }

    public NutritionalValues getNutritionalValues() {
        return nutritionalValues;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public String getSlug() {
        return slug;
    }

    public String pizzaFilterType() {
        return "";
    }
}

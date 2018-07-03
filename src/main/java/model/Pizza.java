package model;

import java.util.UUID;

public class Pizza {
    private String name;
    private UUID uuid;
    private float price;
    private String ingredients;
    private String slug;
    private NutritionalValues nutritionalValues;


    public Pizza(String name, UUID uuid, float price, String ingredients, String slug, NutritionalValues nutritionalValues) {
        this.name = name;
        this.uuid = uuid;
        this.price = price;
        this.ingredients = ingredients;
        this.slug = slug;
        this.nutritionalValues = nutritionalValues;
    }

    public Pizza() {

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

    public String stringRepresentationOfFilter() {
        if(nutritionalValues.getVegetarian().equals("Yes")){
            if(nutritionalValues.getVegan().equals("Yes")) {
                return "vegan-pizza";
            }
            return "veggie-pizza";
        }
        return "meaty-pizza";
    }

    public UUID getUuid() {
        return uuid;
    }
}

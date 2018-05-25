package model;

import java.util.UUID;

public class Pizza {

    private String name;
    private UUID uuid;
    private float price;
    private String ingredients;
    private String slug;
    private NutritionalValues nutritionalValues;

    public Pizza(String name, UUID uuid) {
        this.name = name;
        this.uuid = uuid;
    }

    public Pizza(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public static Pizza create(String name) {
        return new Pizza(name);
    }

    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
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

    public NutritionalValues getNutritionalValues() {
        return nutritionalValues;
    }
}

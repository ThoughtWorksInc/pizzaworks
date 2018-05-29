package dal.dao;

import java.util.UUID;

public class PizzaDAO {

    private String name;
    private UUID uuid;
    private float price;
    private String ingredients;
    private String slug;
    private int energyPerSlice;

    public PizzaDAO(String name, UUID uuid, float price, String ingredients, String slug, int energyPerSlice) {
        this.name = name;
        this.uuid = uuid;
        this.price = price;
        this.ingredients = ingredients;
        this.slug = slug;
        this.energyPerSlice = energyPerSlice;
    }

    public PizzaDAO(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

//    todo remove this if unused
    public static PizzaDAO create(String name) {
        return new PizzaDAO(name);
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

//    public NutritionalValues getNutritionalValues() {
//        return nutritionalValues;
//    }


    public int getEnergyPerSlice() {
        return energyPerSlice;
    }

    public void setEnergyPerSlice(int energyPerSlice) {
        this.energyPerSlice = energyPerSlice;
    }
}

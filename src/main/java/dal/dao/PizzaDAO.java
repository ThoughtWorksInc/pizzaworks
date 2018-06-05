package dal.dao;

import java.util.UUID;

public class PizzaDAO {

    private String name;
    private UUID uuid;
    private float price;
    private String ingredients;
    private String slug;
    // Nutritional Values
    private int weight;
    private int num_slices;
    private int energy_per_slice;
    private float protein_per_slice;
    private float carbohydrate_per_slice;
    private float sugars_per_slice;
    private float fat_per_slice;
    private float saturated_fat_per_slice;
    private float salt_per_slice;
    private int energy_per_100;
    private float protein_per_100;
    private float carbohydrate_per_100;
    private float sugars_per_100;
    private float fat_per_100;
    private float saturated_fat_per_100;
    private float salt_per_100;
    private String allergens;
    private boolean vegetarian;
    private boolean vegan;

    public PizzaDAO(
            String name,
            UUID uuid,
            float price,
            String ingredients,
            String slug,
            int weight,
            int num_slices,
            int energy_per_slice,
            float protein_per_slice,
            float carbohydrate_per_slice,
            float sugars_per_slice,
            float fat_per_slice,
            float saturated_fat_per_slice,
            float salt_per_slice,
            int energy_per_100,
            float protein_per_100,
            float carbohydrate_per_100,
            float sugars_per_100,
            float fat_per_100,
            float saturated_fat_per_100,
            float salt_per_100,
            String allergens,
            boolean vegetarian,
            boolean vegan
        ) {
        this.name = name;
        this.uuid = uuid;
        this.price = price;
        this.ingredients = ingredients;
        this.slug = slug;
        this.weight = weight;
        this.num_slices = num_slices;
        this.energy_per_slice = energy_per_slice;
        this.protein_per_slice = protein_per_slice;
        this.carbohydrate_per_slice = carbohydrate_per_slice;
        this.sugars_per_slice = sugars_per_slice;
        this.fat_per_slice = fat_per_slice;
        this.saturated_fat_per_slice = saturated_fat_per_slice;
        this.salt_per_slice = salt_per_slice;
        this.energy_per_100 = energy_per_100;
        this.protein_per_100 = protein_per_100;
        this.carbohydrate_per_100 = carbohydrate_per_100;
        this.sugars_per_100 = sugars_per_100;
        this.fat_per_100 = fat_per_100;
        this.saturated_fat_per_100 = saturated_fat_per_100;
        this.salt_per_100 = salt_per_100;
        this.allergens = allergens;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }




    public PizzaDAO(String name, UUID uuid, float price, String ingredients, String slug, int energy_per_slice) {
        this.name = name;
        this.uuid = uuid;
        this.price = price;
        this.ingredients = ingredients;
        this.slug = slug;
        this.energy_per_slice = energy_per_slice;
    }

    public PizzaDAO(String name) {
        this.name = name;
        this.uuid = UUID.randomUUID();
    }

    public void setName(String name) {
        this.name = name;
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


    public int getNum_slices() {
        return num_slices;
    }

    public int getEnergy_per_slice() {
        return energy_per_slice;
    }

    public float getProtein_per_slice() {
        return protein_per_slice;
    }


    public float getCarbohydrate_per_slice() {
        return carbohydrate_per_slice;
    }


    public float getSugars_per_slice() {
        return sugars_per_slice;
    }


    public float getFat_per_slice() {
        return fat_per_slice;
    }


    public float getSaturated_fat_per_slice() {
        return saturated_fat_per_slice;
    }


    public float getSalt_per_slice() {
        return salt_per_slice;
    }


    public int getEnergy_per_100() {
        return energy_per_100;
    }


    public float getProtein_per_100() {
        return protein_per_100;
    }


    public float getCarbohydrate_per_100() {
        return carbohydrate_per_100;
    }


    public float getSugars_per_100() {
        return sugars_per_100;
    }


    public float getFat_per_100() {
        return fat_per_100;
    }


    public float getSaturated_fat_per_100() {
        return saturated_fat_per_100;
    }


    public float getSalt_per_100() {
        return salt_per_100;
    }


    public String getAllergens() {
        return allergens;
    }


    public boolean getVegetarian() {
        return vegetarian;
    }


    public boolean getVegan() {
        return vegan;
    }


    public int getWeight() {
        return weight;
    }

}

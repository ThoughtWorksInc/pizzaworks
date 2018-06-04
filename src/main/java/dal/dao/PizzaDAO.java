package dal.dao;

import java.util.UUID;

public class PizzaDAO {

    private String name;
    private UUID uuid;
    private float price;
    private String ingredients;
    private String slug;

    public PizzaDAO(
            String name,
            UUID uuid,
            float price,
            String ingredients,
            String slug,
            int weight,
            int energyPerSlice,
            float proteinPerSlice,
            float carbohydratePerSlice,
            float sugarsPerSlice,
            float fatPerSlice,
            float saturatedFatPerSlice,
            float saltPerSlice,
            int energyPer100,
            float proteinPer100,
            float carbohydratePer100,
            float sugarsPer100,
            float fatPer100,
            float saturatedFatPer100,
            float saltPer100,
            String allergens,
            Boolean vegetarian,
            Boolean vegan
        ) {
        this.name = name;
        this.uuid = uuid;
        this.price = price;
        this.ingredients = ingredients;
        this.slug = slug;
        this.weight = weight;
        this.energyPerSlice = energyPerSlice;
        this.proteinPerSlice = proteinPerSlice;
        this.carbohydratePerSlice = carbohydratePerSlice;
        this.sugarsPerSlice = sugarsPerSlice;
        this.fatPerSlice = fatPerSlice;
        this.saturatedFatPerSlice = saturatedFatPerSlice;
        this.saltPerSlice = saltPerSlice;
        this.energyPer100 = energyPer100;
        this.proteinPer100 = proteinPer100;
        this.carbohydratePer100 = carbohydratePer100;
        this.sugarsPer100 = sugarsPer100;
        this.fatPer100 = fatPer100;
        this.saturatedFatPer100 = saturatedFatPer100;
        this.saltPer100 = saltPer100;
        this.allergens = allergens;
        this.vegetarian = vegetarian;
        this.vegan = vegan;
    }

    private int weight;
    private int energyPerSlice;
    private float proteinPerSlice;
    private float carbohydratePerSlice;
    private float sugarsPerSlice;
    private float fatPerSlice;
    private float saturatedFatPerSlice;
    private float saltPerSlice;
    private int energyPer100;
    private float proteinPer100;
    private float carbohydratePer100;
    private float sugarsPer100;
    private float fatPer100;
    private float saturatedFatPer100;
    private float saltPer100;
    private String allergens;
    private Boolean vegetarian;
    private Boolean vegan;


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

    public float getProteinPerSlice() {
        return proteinPerSlice;
    }

    public void setProteinPerSlice(float proteinPerSlice) {
        this.proteinPerSlice = proteinPerSlice;
    }

    public float getCarbohydratePerSlice() {
        return carbohydratePerSlice;
    }

    public void setCarbohydratePerSlice(float carbohydratePerSlice) {
        this.carbohydratePerSlice = carbohydratePerSlice;
    }

    public float getSugarsPerSlice() {
        return sugarsPerSlice;
    }

    public void setSugarsPerSlice(float sugarsPerSlice) {
        this.sugarsPerSlice = sugarsPerSlice;
    }

    public float getFatPerSlice() {
        return fatPerSlice;
    }

    public void setFatPerSlice(float fatPerSlice) {
        this.fatPerSlice = fatPerSlice;
    }

    public float getSaturatedFatPerSlice() {
        return saturatedFatPerSlice;
    }

    public void setSaturatedFatPerSlice(float saturatedFatPerSlice) {
        this.saturatedFatPerSlice = saturatedFatPerSlice;
    }

    public float getSaltPerSlice() {
        return saltPerSlice;
    }

    public void setSaltPerSlice(float saltPerSlice) {
        this.saltPerSlice = saltPerSlice;
    }

    public int getEnergyPer100() {
        return energyPer100;
    }

    public void setEnergyPer100(int energyPer100) {
        this.energyPer100 = energyPer100;
    }

    public float getProteinPer100() {
        return proteinPer100;
    }

    public void setProteinPer100(float proteinPer100) {
        this.proteinPer100 = proteinPer100;
    }

    public float getCarbohydratePer100() {
        return carbohydratePer100;
    }

    public void setCarbohydratePer100(float carbohydratePer100) {
        this.carbohydratePer100 = carbohydratePer100;
    }

    public float getSugarsPer100() {
        return sugarsPer100;
    }

    public void setSugarsPer100(float sugarsPer100) {
        this.sugarsPer100 = sugarsPer100;
    }

    public float getFatPer100() {
        return fatPer100;
    }

    public void setFatPer100(float fatPer100) {
        this.fatPer100 = fatPer100;
    }

    public float getSaturatedFatPer100() {
        return saturatedFatPer100;
    }

    public void setSaturatedFatPer100(float saturatedFatPer100) {
        this.saturatedFatPer100 = saturatedFatPer100;
    }

    public float getSaltPer100() {
        return saltPer100;
    }

    public void setSaltPer100(float saltPer100) {
        this.saltPer100 = saltPer100;
    }

    public String getAllergens() {
        return allergens;
    }

    public void setAllergens(String allergens) {
        this.allergens = allergens;
    }

    public Boolean getVegetarian() {
        return vegetarian;
    }

    public void setVegetarian(Boolean vegetarian) {
        this.vegetarian = vegetarian;
    }

    public Boolean getVegan() {
        return vegan;
    }

    public void setVegan(Boolean vegan) {
        this.vegan = vegan;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

}

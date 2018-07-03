package builders;

import dal.dao.PizzaDAO;

import java.util.UUID;

public class PizzaDaoBuilder {
    private String pizzaName = "testPizza";
    private int energyPerSlice = 1;
    private float price = 1.0f;
    private String ingredients = "ingredients";
    private String slug = "slug";
    private UUID uuid = UUID.randomUUID();
    private int weight = 1;
    private int numSlices = 1;
    private float proteinPerSlice = 1;
    private float carbohydratePerSlice = 1;
    private float sugarsPerSlice = 1;
    private float fatPerSlice = 1;
    private float saturatedFatPerSlice = 1;
    private float saltPerSlice = 1 ;
    private int  energyPer100 = 1;
    private float proteinPer100 = 1;
    private float carbohydratePer100 = 1 ;
    private float sugarsPer100 = 1;
    private float fatPer100 = 1;
    private float saturatedFatPer100 = 1;
    private float saltPer100 = 1;
    private String allergens = "allergens";
    private boolean vegetarian = true;
    private boolean vegan = true;




    public static PizzaDaoBuilder pizzaDao() {
        return new PizzaDaoBuilder();
    }

    public PizzaDaoBuilder withName(String pizzaName) {
        this.pizzaName = pizzaName;
        return this;
    }

    public PizzaDaoBuilder withEnergyPerSlice(int energyPerSlice) {
        this.energyPerSlice = energyPerSlice;
        return this;
    }

    public PizzaDAO build() {
        return new PizzaDAO(pizzaName, uuid, price, ingredients, slug, weight, numSlices, energyPerSlice, proteinPerSlice, carbohydratePerSlice, sugarsPerSlice,
                fatPerSlice, saturatedFatPerSlice, saltPerSlice, energyPer100, proteinPer100, carbohydratePer100, sugarsPer100, fatPer100, saturatedFatPer100, saltPer100,
                allergens, vegetarian, vegan);
    }
}

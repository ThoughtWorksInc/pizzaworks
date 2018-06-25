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
        return new PizzaDAO(pizzaName, uuid, price, ingredients, slug, energyPerSlice);
    }
}

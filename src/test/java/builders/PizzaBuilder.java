package builders;

import model.NutritionalValues;
import model.Pizza;

import java.util.UUID;

public class PizzaBuilder {
    private String pizzaName = "testPizza";
    private float price = 1.0f;
    private String ingredients = "ingredients";
    private String slug = "slug";
    private UUID uuid = UUID.randomUUID();
    private NutritionalValues nutritionalValues =  new NutritionalValues(1, 1, 1, 1, 1,
            1, 1, 1, 1, 1, 1, 1, 1,
            1, 1, 1, "allergens", false, false);


    public static PizzaBuilder pizza() {
        return new PizzaBuilder();
    }

    public PizzaBuilder withName(String pizzaName) {
        this.pizzaName = pizzaName;
        return this;
    }

    public PizzaBuilder withPrice(float price) {
        this.price = price;
        return this;
    }

    public PizzaBuilder withIngredients(String ingredients){
        this.ingredients = ingredients;
        return this;
    }

    public PizzaBuilder withSlug(String slug){
        this.slug = slug;
        return this;
    }

    public Pizza build (){
        return new Pizza(pizzaName, uuid, price, ingredients, slug, nutritionalValues);
    }

    public PizzaBuilder withNutritionalValues (NutritionalValues nutritionalValues){
        this.nutritionalValues = nutritionalValues;
        return this;

    }
}

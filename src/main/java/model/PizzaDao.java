package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PizzaDao {

    private static final List<Pizza> PIZZAS = new ArrayList<>();

    public static void add(Pizza pizza) {
        PIZZAS.add(pizza);
    }

    public static Pizza find(String id) {
        return PIZZAS.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

    public static List<Pizza> all() {
        return PIZZAS;
    }

    public static Integer count() {
        return PIZZAS.size();
    }

    public static void remove(String id) {
        Optional<Pizza> pizzaToRemove = PIZZAS.stream().filter(pizza -> pizza.getId().equals(id)).findFirst();
        pizzaToRemove.ifPresent(PIZZAS::remove);
    }

    public static void clearPizzas() {
        PIZZAS.clear();
    }
}

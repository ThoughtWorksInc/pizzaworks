package model;

import java.util.ArrayList;
import java.util.List;

public class PizzaDao {

    private static final List<Pizza> PIZZAS = new ArrayList<>();

    public static void add(Pizza pizza) {
        PIZZAS.add(pizza);
    }

    public static Pizza find(String id) {
        return PIZZAS.stream().filter(t -> t.getId().equals(id)).findFirst().orElse(null);
    }

//    public static List<Pizza> ofStatus(String statusString) {
//        return (statusString == null || statusString.isEmpty()) ? PIZZAS : ofStatus(Status.valueOf(statusString.toUpperCase()));
//    }
//
//    public static List<Pizza> ofStatus(Status status) {
//        return PIZZAS.stream().filter(t -> t.getStatus().equals(status)).collect(Collectors.toList());
//    }

    public static List<Pizza> all() {
        return PIZZAS;
    }

    public static Integer count() {
        return PIZZAS.size();
    }
}

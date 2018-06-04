package mappers;

import dal.dao.PizzaDAO;
import model.NutritionalValues;
import model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PizzaMapper {

    public static Pizza toPizza(PizzaDAO pizzaDAO) {

        NutritionalValues nutritionalValues = new NutritionalValues(pizzaDAO.getEnergyPerSlice());
        return new Pizza(pizzaDAO.getName(), pizzaDAO.getUuid(), pizzaDAO.getPrice(), pizzaDAO.getIngredients(), pizzaDAO.getSlug(), nutritionalValues);
    }

    public static List<Pizza> fromPizzaDaos(List<PizzaDAO> pizzaDAOS) {

        return pizzaDAOS.stream()
                .map(PizzaMapper::toPizza)
                .collect(Collectors.toList());

    }
}

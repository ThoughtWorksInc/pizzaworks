package mappers;

import dal.dao.PizzaDAO;
import model.NutritionalValues;
import model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class PizzaMapper {

    public static Pizza toPizza(PizzaDAO pizzaDAO) {

        // Define nutritional values
        NutritionalValues nutritionalValues = new NutritionalValues(pizzaDAO.getEnergyPerSlice());

        // Create pizza object
        return new Pizza(pizzaDAO.getName(), pizzaDAO.getUuid(), pizzaDAO.getPrice(), pizzaDAO.getIngredients(), pizzaDAO.getSlug(), nutritionalValues);
    }

    public static List<Pizza> fromPizzaDaos(List<PizzaDAO> pizzaDAOS) {

        List<Pizza> pizzaList = new ArrayList<Pizza>();

        for (PizzaDAO pizzaDAO : pizzaDAOS) {
            pizzaList.add(PizzaMapper.toPizza(pizzaDAO));
        }

        return pizzaList;

    }
}

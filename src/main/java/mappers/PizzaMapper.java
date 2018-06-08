package mappers;

import dal.dao.PizzaDAO;
import model.NutritionalValues;
import model.Pizza;

import java.util.List;
import java.util.stream.Collectors;

public class PizzaMapper {

    public static Pizza toPizza(PizzaDAO pizzaDAO) {

        NutritionalValues nutritionalValues = new NutritionalValues(
                pizzaDAO.getWeight(),
                pizzaDAO.getNum_slices(),
                pizzaDAO.getEnergy_per_slice(),
                pizzaDAO.getProtein_per_slice(),
                pizzaDAO.getCarbohydrate_per_slice(),
                pizzaDAO.getSugars_per_slice(),
                pizzaDAO.getFat_per_slice(),
                pizzaDAO.getSaturated_fat_per_slice(),
                pizzaDAO.getSalt_per_slice(),
                pizzaDAO.getEnergy_per_100(),
                pizzaDAO.getProtein_per_100(),
                pizzaDAO.getCarbohydrate_per_100(),
                pizzaDAO.getSugars_per_100(),
                pizzaDAO.getFat_per_100(),
                pizzaDAO.getSaturated_fat_per_100(),
                pizzaDAO.getSalt_per_100(),
                pizzaDAO.getAllergens(),
                pizzaDAO.getVegetarian(),
                pizzaDAO.getVegan()
        );

        return new Pizza(pizzaDAO.getName(), pizzaDAO.getUuid(), pizzaDAO.getPrice(), pizzaDAO.getIngredients(), pizzaDAO.getSlug(), nutritionalValues);
    }

    public static List<Pizza> fromPizzaDaos(List<PizzaDAO> pizzaDAOS) {

        return pizzaDAOS.stream()
                .map(PizzaMapper::toPizza)
                .collect(Collectors.toList());

    }
}

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

    public static PizzaDAO toPizzaDao(Pizza pizza) {

        return new PizzaDAO(pizza.getName(), pizza.getUuid(), pizza.getPrice(), pizza.getIngredients(), pizza.getSlug(),
                pizza.getNutritionalValues().getWeight(),
                pizza.getNutritionalValues().getNum_slices(),
                pizza.getNutritionalValues().getEnergy_per_slice(),
                pizza.getNutritionalValues().getProtein_per_slice(),
                pizza.getNutritionalValues().getCarbohydrate_per_slice(),
                pizza.getNutritionalValues().getSugars_per_slice(),
                pizza.getNutritionalValues().getFat_per_slice(),
                pizza.getNutritionalValues().getSaturated_fat_per_slice(),
                pizza.getNutritionalValues().getSalt_per_slice(),
                pizza.getNutritionalValues().getEnergy_per_100(),
                pizza.getNutritionalValues().getProtein_per_100(),
                pizza.getNutritionalValues().getCarbohydrate_per_100(),
                pizza.getNutritionalValues().getSugars_per_100(),
                pizza.getNutritionalValues().getFat_per_100(),
                pizza.getNutritionalValues().getSaturated_fat_per_100(),
                pizza.getNutritionalValues().getSalt_per_100(),
                pizza.getNutritionalValues().getAllergens(),
                pizza.getNutritionalValues().getVegetarian().equals(NutritionalValues.YES),
                pizza.getNutritionalValues().getVegan().equals(NutritionalValues.YES));

    }

}

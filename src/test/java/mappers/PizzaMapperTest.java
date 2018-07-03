package mappers;

import builders.PizzaBuilder;
import builders.PizzaDaoBuilder;
import dal.dao.PizzaDAO;
import model.NutritionalValues;
import model.Pizza;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PizzaMapperTest {

    @Test
    public void shouldMapToPizzaObject() {
        PizzaDAO pizzaDAO = PizzaDaoBuilder.pizzaDao()
                .withName("pizzaName")
                .withEnergyPerSlice(2)
                .build();

        Pizza pizza = PizzaMapper.toPizza(pizzaDAO);

        assertThat(pizza.getNutritionalValues().getEnergy_per_slice(), is(2));
        assertThat(pizza.getName(), is("pizzaName"));
    }

    @Test
    public void shouldReturnListOfPizzaObjectsFromPizzaDAOs() {
        PizzaDAO pizzaDAO = PizzaDaoBuilder.pizzaDao()
                .withName("pizzaName")
                .build();

        List<PizzaDAO> listOfPizzaDAOs = new ArrayList<PizzaDAO>() {
        };
        listOfPizzaDAOs.add(pizzaDAO);
        listOfPizzaDAOs.add(pizzaDAO);

        assertThat(PizzaMapper.fromPizzaDaos(listOfPizzaDAOs).size(), is(2));
        assertThat(PizzaMapper.fromPizzaDaos(listOfPizzaDAOs).get(0).getName(), is("pizzaName"));

    }

    @Test
    public void shouldReturnPizzaDaoFromListOfPizzaObjects() {
        Pizza pizza = PizzaBuilder.pizza()
                .withName("pizzaName")
                .withPrice(1)
                .withIngredients("ingredients")
                .withSlug("slug")
                .build();


        PizzaDAO pizzaDao = PizzaMapper.toPizzaDao(pizza);
        assertThat(pizzaDao.getName(), is("pizzaName"));

    }


}
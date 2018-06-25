package mappers;

import builders.PizzaDaoBuilder;
import dal.dao.PizzaDAO;
import model.Pizza;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

        assertThat(PizzaMapper.fromPizzaDaos(listOfPizzaDAOs).size(), is(1));
        assertThat(PizzaMapper.fromPizzaDaos(listOfPizzaDAOs).get(0).getName(), is("pizzaName"));

    }

}
package mappers;

import dal.dao.PizzaDAO;
import model.Pizza;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PizzaMapperTest {

    @Test
    public void shouldMapToPizzaObject() {

        PizzaDAO pizzaDAO = new PizzaDAO("pizzaName", UUID.randomUUID(), 1.0f, "ingredients", "slug", 1);

        Pizza pizza = PizzaMapper.toPizza(pizzaDAO);

        assertThat(pizza.getNutritionalValues().getEnergy_per_slice(), is(1));
        assertThat(pizza.getName(), is("pizzaName"));
    }

    @Test
    public void shouldReturnListOfPizzaObjectsFromPizzaDAOs() {
        PizzaDAO pizzaDAO = new PizzaDAO("pizzaName", UUID.randomUUID(), 1.0f, "ingredients", "slug", 1);

        List<PizzaDAO> listOfPizzaDAOs = new ArrayList<PizzaDAO>() {};
        listOfPizzaDAOs.add(pizzaDAO);

        assertThat(PizzaMapper.fromPizzaDaos(listOfPizzaDAOs).size(), is(1));
        assertThat(PizzaMapper.fromPizzaDaos(listOfPizzaDAOs).get(0).getName(), is("pizzaName"));

    }

}
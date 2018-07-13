package integration;

import dal.PizzaService;
import functional.helpers.DatabaseSetupRule;
import mappers.PizzaMapper;
import model.NutritionalValues;
import model.Pizza;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertThat;


public class PizzaServiceIntegrationTest {

    private PizzaService pizzaService;


    @ClassRule
    public static DatabaseSetupRule dbSetupRule = new DatabaseSetupRule();

    private Sql2o sql2o = dbSetupRule.getSql2o();

    private List<Pizza> pizzasToDelete = new ArrayList<>();


    @Before
    public void setUp() {
        pizzaService = new PizzaService(sql2o);

    }

    @Test
    public void shouldRetrievePizzas() {

        List<Pizza> allPizzas = pizzaService.getAllPizzas();
        assertThat(allPizzas.size(), is(4));

        Pizza veggiePizza = getPizzaByName(allPizzas, "Veggie");
        Pizza pepperoniPizza = getPizzaByName(allPizzas, "Pepperoni feast");

        assertThat(veggiePizza.getName(), is("Veggie"));
        assertThat(veggiePizza.getSlug(), is("veggie"));
        assertThat(veggiePizza.getIngredients(), is("Pizza sauce, vegan alternative to cheese, spinach, sweetcorn, mixed peppers, red onion, mushrooms"));
        assertThat(veggiePizza.getPrice(), is(12.99F));

        assertThat(pepperoniPizza.getName(), is("Pepperoni feast"));
        assertThat(pepperoniPizza.getSlug(), is("pepperoni-feast"));
        assertThat(pepperoniPizza.getIngredients(), is("Pizza sauce, mozzarella cheese, pepperoni"));
        assertThat(pepperoniPizza.getPrice(), is(13.99F));
    }

    @Test
    public void shouldRetrievePizzaBySlug() {
        Pizza veggie = pizzaService.getPizzaBySlug("veggie").get();
        assertThat((veggie.getName()), is("Veggie"));

    }

    private Pizza getPizzaByName(List<Pizza> allPizzas, String pizzaName) {
        return allPizzas.stream()
                .filter(pizza -> pizza.getName().equals(pizzaName))
                .findFirst().get();
    }


    @Test
    public void shouldReturnEmptyOptionalIfNoPizzaWithSlugCanBeFound() {
        Optional<Pizza> optional = pizzaService.getPizzaBySlug("pizzadoesnotexist");
        assertFalse(optional.isPresent());
    }


    @Test
    public void shouldRetrieveNewlyAddedPizza() {
        NutritionalValues nutritionalValues1 = new NutritionalValues(1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, "all", true, false);

        Pizza newPizza = new Pizza("apples", UUID.randomUUID(), 12, "tomato", "apples", nutritionalValues1);

        Pizza newPizza1 = new Pizza("apples1", UUID.randomUUID(), 12, "tomato", "apples", nutritionalValues1);
        pizzaService.createPizza(newPizza);
        pizzasToDelete.add(newPizza);
        pizzasToDelete.add(newPizza1);
//        sql2o.open().rollback();
        List<Pizza> newPizzas = pizzaService.getAllPizzas();
        assertThat((newPizzas.size()), is(5));
        assertThat((newPizzas.get(4).getName()), is("apples"));
        assertThat((pizzasToDelete.get(1).getName()), is("apples1"));
        assertThat((pizzasToDelete.size()), is(2));

    }

    @After
    public void after() {
        try (Connection conn = sql2o.open()) {
        pizzasToDelete.stream().forEach(pizza ->
            conn.createQuery("Delete from pizza where uuid = :uuid")
                    .addParameter("uuid", pizza.getUuid())
                    .executeUpdate());
        }
    }
}
package model;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class PizzaDaoTest {
    private Pizza firstPizza;

    @Before
    public void setUp() {
        firstPizza = new Pizza("test", "id1");
        PizzaDao.add(firstPizza);
        PizzaDao.add(new Pizza("test2", "id2"));
    }

    @Test
    public void shouldKnowTotalCountOfPizzas() {
        assertThat(PizzaDao.count(), is(2));
    }

    @Test
    public void shouldRemovePizzaFromList() {
        PizzaDao.remove("id2");
        assertThat(PizzaDao.count(), is(1));
        assertThat(PizzaDao.all().get(0), is(firstPizza));
    }

    @After
    public void tearDown() {
        PizzaDao.clearPizzas();
    }
}
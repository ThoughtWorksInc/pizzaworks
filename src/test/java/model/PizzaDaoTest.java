package model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PizzaDaoTest {
    Pizza firstPizza;

    @BeforeEach
    void setUp() {
        firstPizza = new Pizza("test", "id1");
        PizzaDao.add(firstPizza);
        PizzaDao.add(new Pizza("test2", "id2"));
    }

    @Test
    void shouldKnowTotalCountOfPizzas() throws Exception {
        assertThat(PizzaDao.count(), is(2));
    }

    @Test
    void shouldRemovePizzaFromList() throws Exception {
        PizzaDao.remove("id2");
        assertThat(PizzaDao.count(), is(1));
        assertThat(PizzaDao.all().get(0), is(firstPizza));
    }

    @AfterEach
    void tearDown() {
        PizzaDao.clearPizzas();
    }
}
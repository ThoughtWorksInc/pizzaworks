package model;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

class PizzaDaoTest {
    @Test
    void shouldKnowTotalCountOfPizzas() throws Exception {
        PizzaDao.add(new Pizza("test"));
        PizzaDao.add(new Pizza("test2"));
        assertThat(PizzaDao.count(), is(2));
    }

}
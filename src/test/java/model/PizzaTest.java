package model;

import builders.PizzaBuilder;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PizzaTest {

    @Test
    public void shouldKnowWhenPizzaIsValid() {
        //create pizza with all attributes

        //assert that isValid is true

        Pizza pizza = PizzaBuilder.pizza().build();
        assertTrue(pizza.isValid());
    }

    @Test
    public void shouldKnowPizzaIsInvalidIfMissingName() {
        //create pizza with all attributes except name
        Pizza pizza = PizzaBuilder.pizza().withName("").build();

        //assert that isValid is false
        assertFalse(pizza.isValid());
    }

    @Test
    public void shouldKnowPizzaIsInvalidIfMissingPrice() {
        //create pizza with all attributes except name
        Pizza pizza = PizzaBuilder.pizza().withPrice(0).build();

        //assert that isValid is false
        assertFalse(pizza.isValid());
    }

    @Test
    public void shouldKnowPizzaIsInvalidIfMissingSlug() {
        //create pizza with all attributes except name
        Pizza pizza = PizzaBuilder.pizza().withSlug("").build();

        //assert that isValid is false
        assertFalse(pizza.isValid());
    }

}
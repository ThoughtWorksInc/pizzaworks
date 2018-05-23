package dal;

import model.Pizza;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;

public class PizzaService {
    private Sql2o sql2o;

    public PizzaService(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    public List<Pizza> getAllPizzas() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from pizza")
                    .executeAndFetch(Pizza.class);
        }
    }
}

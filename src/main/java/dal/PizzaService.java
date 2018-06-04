package dal;

import dal.dao.PizzaDAO;
import mappers.PizzaMapper;
import model.Pizza;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.List;
import java.util.Optional;

public class PizzaService {
    private Sql2o sql2o;

    public PizzaService(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public Optional<Pizza> getPizzaBySlug(String slug) {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from pizza where slug = :slug")
                    .addParameter("slug", slug)
                    .executeAndFetch(PizzaDAO.class)
                    .stream()
                    .map(PizzaMapper::toPizza)
                    .findFirst();
        }
    }

    public List<Pizza> getAllPizzas() {
        try (Connection conn = sql2o.open()) {
            return PizzaMapper.fromPizzaDaos(conn.createQuery("select * from pizza")
                    .executeAndFetch(PizzaDAO.class));
        }
    }
}

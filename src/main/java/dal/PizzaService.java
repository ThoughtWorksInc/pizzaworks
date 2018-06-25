package dal;

import dal.dao.PizzaDAO;
import mappers.PizzaMapper;
import model.Order;
import model.Pizza;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public Optional<Pizza> getPizzaFromOrder(UUID pizza_id) {
        try (Connection conn = sql2o.open()) {
            return Optional.of(PizzaMapper.toPizza(conn.createQuery("select * from pizza where uuid = :pizza_id")
                    .addParameter("pizza_id", pizza_id)
                    .executeAndFetchFirst(PizzaDAO.class)));
        }
    }

    public void createPizza(pizza) {
        String insertSql =
                "insert into pizza(uuid, name, ingredients, price, slug, weight, num_slices, energy_per_slice, protein_per_slice , carbohydrate_per_slice, " +
                        "sugars_per_slice, fat_per_slice, saturated_fat_per_slice, salt_per_slice, energy_per_100, protein_per_100, carbohydrate_per_100," +
                        "sugars_per_100, fat_per_100, saturated_fat_per_100, salt_per_100, allergens, vegetarian, vegan)" +
                        "values (:pizza_uuid, :pizzaName, :ingredients, :price, :slug, :weight, :num_slices,  :energy_per_slice, :protein_per_slice , :carbohydrate_per_slice," +
                        ":sugars_per_slice, :fat_per_slice, :saturated_fat_per_slice, :salt_per_slice, :energy_per_100, :protein_per_100, :carbohydrate_per_100," +
                        ":sugars_per_100, :fat_per_100, :saturated_fat_per_100, :salt_per_100, :allergens, :vegetarian, :vegan)";

        try (Connection con = sql2o.open()) {
            UUID value = UUID.randomUUID();
            con.createQuery(insertSql)
                    .bind(PizzaMapper.toPizzaDao(pizza))
                    .executeUpdate();

        }
    }

}

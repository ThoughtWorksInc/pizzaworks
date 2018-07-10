package dal;

import dal.dao.PizzaDAO;
import mappers.PizzaMapper;
import model.Pizza;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

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

    public List<Pizza> createPizza(Pizza pizza) {
        String insertSql =
                "insert into pizza(uuid, name, ingredients, price, slug, weight, num_slices, energy_per_slice, protein_per_slice , carbohydrate_per_slice, " +
                        "sugars_per_slice, fat_per_slice, saturated_fat_per_slice, salt_per_slice, energy_per_100, protein_per_100, carbohydrate_per_100," +
                        "sugars_per_100, fat_per_100, saturated_fat_per_100, salt_per_100, allergens, vegetarian, vegan)" +
                        "values (:pizza_uuid, :pizzaName, :ingredients, :price, :slug, :weight, :num_slices,  :energy_per_slice, :protein_per_slice , :carbohydrate_per_slice," +
                        ":sugars_per_slice, :fat_per_slice, :saturated_fat_per_slice, :salt_per_slice, :energy_per_100, :protein_per_100, :carbohydrate_per_100," +
                        ":sugars_per_100, :fat_per_100, :saturated_fat_per_100, :salt_per_100, :allergens, :vegetarian, :vegan)";


        try (Connection conn = sql2o.open()) {
            UUID value = UUID.randomUUID();
            conn.createQuery(insertSql)
                    .addParameter("pizza_uuid",value)
                    .addParameter("pizzaName",pizza.getName())
                    .addParameter("ingredients",pizza.getIngredients())
                    .addParameter("price",pizza.getPrice())
                    .addParameter("slug",pizza.getSlug())
                    .addParameter("weight",pizza.getNutritionalValues().getWeight())
                    .addParameter("num_slices",pizza.getNutritionalValues().getNum_slices())
                    .addParameter("energy_per_slice",pizza.getNutritionalValues().getEnergy_per_slice())
                    .addParameter("protein_per_slice",pizza.getNutritionalValues().getProtein_per_slice())
                    .addParameter("carbohydrate_per_slice",pizza.getNutritionalValues().getCarbohydrate_per_slice())
                    .addParameter("sugars_per_slice",pizza.getNutritionalValues().getSugars_per_slice())
                    .addParameter("fat_per_slice",pizza.getNutritionalValues().getFat_per_slice())
                    .addParameter("saturated_fat_per_slice",pizza.getNutritionalValues().getSaturated_fat_per_slice())
                    .addParameter("salt_per_slice",pizza.getNutritionalValues().getSalt_per_slice())
                    .addParameter("energy_per_100",pizza.getNutritionalValues().getEnergy_per_100())
                    .addParameter("protein_per_100",pizza.getNutritionalValues().getProtein_per_100())
                    .addParameter("carbohydrate_per_100",pizza.getNutritionalValues().getCarbohydrate_per_100())
                    .addParameter("sugars_per_100",pizza.getNutritionalValues().getSugars_per_100())
                    .addParameter("fat_per_100",pizza.getNutritionalValues().getFat_per_100())
                    .addParameter("saturated_fat_per_100",pizza.getNutritionalValues().getSaturated_fat_per_100())
                    .addParameter("salt_per_100",pizza.getNutritionalValues().getSalt_per_100())
                    .addParameter("allergens",pizza.getNutritionalValues().getAllergens())
                    .addParameter("vegetarian",true)
                    .addParameter("vegan",true)

//                    .bind(PizzaMapper.toPizzaDao(pizza))
                    .executeUpdate();

            return PizzaMapper.fromPizzaDaos(conn.createQuery("select * from pizza")
                    .executeAndFetch(PizzaDAO.class));
        }
    }

}
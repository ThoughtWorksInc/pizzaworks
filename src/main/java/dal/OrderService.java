package dal;

import dal.dao.PizzaDAO;
import mappers.PizzaMapper;
import model.Order;
import model.Pizza;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;

public class OrderService {

    private Sql2o sql2o;

    public OrderService(Sql2o sql2o) {
        this.sql2o = sql2o;
    }



    public Order createOrder(String customerName, String pizzaId) {
        String insertSql =
                "insert into pizza_order(uuid, order_number , customer_name, pizza_id, price, timestamp ) " +
                        "values (:uuid, nextval('order_number_sequence'), :customerName, :pizza_uuid, (SELECT price FROM PIZZA WHERE uuid = :pizza_uuid), :timestamp)";

        try (Connection con = sql2o.open()) {
            UUID value = UUID.randomUUID();
            con.createQuery(insertSql)
                    .addParameter("uuid", value)
                    .addParameter("customerName", customerName)
                    .addParameter("pizza_uuid", UUID.fromString(pizzaId))
                    .addParameter("timestamp", new Date())
                    .executeUpdate();

            return con.createQuery("select * from pizza_order where uuid = :orderNumber")
                    .addParameter("orderNumber", value)
                    .executeAndFetch(Order.class).get(0);

        }
    }
    public Optional<Pizza> getPizzaFromOrder(Order order) {
        try (Connection conn = sql2o.open()) {
            return Optional.of(PizzaMapper.toPizza(conn.createQuery("select * from pizza where uuid = :pizza_id")
                    .addParameter("pizza_id", order.getPizza_id())
                    .executeAndFetchFirst(PizzaDAO.class)));
        }
    }

}
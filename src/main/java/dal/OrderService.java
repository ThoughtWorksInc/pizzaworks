package dal;

import model.Order;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import java.util.Date;
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

            return con.createQuery("select * from pizza_order where uuid = :uuid")
                    .addParameter("uuid", value)
                    .executeAndFetch(Order.class).get(0);

        }
    }


}
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

import static com.sun.tools.doclets.formats.html.markup.HtmlStyle.bar;

public class OrderService {

    private Sql2o sql2o;

    public OrderService(Sql2o sql2o) {
        this.sql2o = sql2o;
    }


    private long getOrderNumber() {
//        String newUUID =  this.uuid.toString();
        return 55555;
//        this.orderNumber = ( Long.parseLong(newUUID) * 5);
//        return this.orderNumber;
    }


    public void createOrder(String customerName, Pizza pizza) {
        String insertSql =
                "insert into pizza_order(uuid, order_number , customer_name, pizza_id, price, timestamp ) " +
                        "values (:uuid, :orderNumber, :customerName, :pizza_uuid, :pizza_price, :timestamp)";

        try (Connection con = sql2o.open()) {
            con.createQuery(insertSql)
                    .addParameter("uuid", UUID.randomUUID())
                    .addParameter("orderNumber", getOrderNumber())
                    .addParameter("customerName", customerName )
                    .addParameter("pizza_uuid", pizza.getUuid())
                    .addParameter("pizza_price", pizza.getPrice())
                    .addParameter("timestamp", new Date())

                    .executeUpdate();
        }
    }

    public List<Order> getOrder() {
        try (Connection conn = sql2o.open()) {
            return conn.createQuery("select * from pizza_order where order_number = :orderNumber")
                    .addParameter("orderNumber", getOrderNumber())
                    .executeAndFetch(Order.class);

        }
    }
}

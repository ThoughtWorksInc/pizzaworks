package dal;

import model.Pizza;
import org.sql2o.Sql2o;

public class OrderService {

    private Sql2o sql2o;

    public OrderService(Sql2o sql2o) {
        this.sql2o = sql2o;
    }

    public void createOrder(String customerName, Pizza pizza) {

    }
}

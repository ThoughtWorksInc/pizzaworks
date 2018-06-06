package model;

import java.sql.Timestamp;
import java.util.UUID;

public class Order {

    private UUID uuid;
    private int order_number;
    private String customer_name;
    private UUID pizza_id;
    private float price;

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public int getOrder_number() {
        return order_number;
    }

    public void setOrder_number(int order_number) {
        this.order_number = order_number;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public UUID getPizza_id() {
        return pizza_id;
    }

    public void setPizza_id(UUID pizza_id) {
        this.pizza_id = pizza_id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    private Timestamp timestamp;

}

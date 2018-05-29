package model;

import java.sql.Timestamp;
import java.util.UUID;

public class Order {

    private UUID uuid;
    private int orderNumber;
    private String customerName;
    private Pizza pizza;
    private float price;
    private Timestamp timestamp;

}

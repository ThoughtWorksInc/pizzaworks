package model;

import java.util.UUID;

public class Pizza {
    private String name;
    private String id;

    public Pizza(String name, String id) {
        this.name = name;
        this.id = id;
    }

    public Pizza(String name) {
        this.name = name;
        this.id = UUID.randomUUID().toString();
    }

    public static Pizza create(String name) {
        return new Pizza(name);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

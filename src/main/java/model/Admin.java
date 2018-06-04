package model;

import java.util.UUID;

public class Admin {
    private String name;
    private UUID uuid;
    private String hashcode;



    public Admin(String name, UUID uuid, String hashcode){
        this.name = name;
        this.uuid = uuid;
        this.hashcode = hashcode;
    }


    public String getName() {
        return name;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getHashcode() {
        return hashcode;
    }


}

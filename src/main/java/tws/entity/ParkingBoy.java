package tws.entity;

import java.io.Serializable;

//public class Employee implements Serializable {
public class ParkingBoy{
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ParkingBoy(String id) {
        this.id = id;
    }

    public ParkingBoy() {
    }
}

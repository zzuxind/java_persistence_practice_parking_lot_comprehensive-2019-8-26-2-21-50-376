package tws.entity;

public class ParkingLot {
    private String id;
    private int capacity;
    private String parkingboyid;

    public String getParkingboyid() {
        return parkingboyid;
    }

    public void setParkingboyid(String parkingboyid) {
        this.parkingboyid = parkingboyid;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot(String id, int capacity,String parkingboyid) {
        this.id = id;
        this.capacity = capacity;
        this.parkingboyid=parkingboyid;
    }

    public ParkingLot() {
    }
}

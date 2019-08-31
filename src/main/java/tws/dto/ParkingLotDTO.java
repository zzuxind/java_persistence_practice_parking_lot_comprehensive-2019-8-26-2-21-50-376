package tws.dto;

public class ParkingLotDTO {
    private String id;
    private int capacity;
    //private int size;
    private  String parkingboyid;

    public void setParkingboyid(String parkingboyid) {
        this.parkingboyid = parkingboyid;
    }

    public String getParkingboyid() {
        return parkingboyid;
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

//    public void setSize(int size) {
//        this.size = size;
//    }
//
//    public int getSize() {
//        return size;
//    }
}

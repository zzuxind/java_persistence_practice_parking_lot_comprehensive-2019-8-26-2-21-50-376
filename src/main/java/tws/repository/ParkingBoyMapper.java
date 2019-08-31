package tws.repository;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tws.entity.ParkingBoy;
import java.util.List;

@Mapper
public interface ParkingBoyMapper {
    public List<ParkingBoy> getParkingBoys();

    public void creatParkingBoy(@Param("parkingBoy") ParkingBoy parkingBoy);


}

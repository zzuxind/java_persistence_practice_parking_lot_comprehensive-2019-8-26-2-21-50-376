package tws.repository;



import org.apache.ibatis.annotations.Mapper;
import tws.entity.ParkingBoy;
import java.util.List;

@Mapper
public interface ParkingBoyMapper {
    public List<ParkingBoy> getParkingBoys();

}

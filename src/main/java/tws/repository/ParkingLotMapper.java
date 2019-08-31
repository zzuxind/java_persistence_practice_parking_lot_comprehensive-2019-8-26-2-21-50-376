package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tws.entity.ParkingLot;

import java.util.List;

@Mapper
public interface ParkingLotMapper {
    List<ParkingLot> getParkingLots();
    void creatParkingLot(@Param("parkingLot") ParkingLot parkingLot);

    int addParkinglotToParkingboy(@Param("parkingboyid") String parkingboyID, @Param("parkinglotid") String parkinglotID);

    List<ParkingLot> getParkingLotsByParkingBoyID(@Param("parkingboyid") String parkingboyID);
}

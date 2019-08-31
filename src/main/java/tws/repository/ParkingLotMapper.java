package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import tws.entity.ParkingLot;

import java.util.List;

@Mapper
public interface ParkingLotMapper {
    List<ParkingLot> getParkingLots();
    void creatParkingLot(@Param("parkingLot") ParkingLot parkingLot);
}

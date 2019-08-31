package tws.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.dto.ParkingBoyDTO;
import tws.dto.ParkingLotDTO;
import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class ParkingLotService {
    @Autowired
    ParkingLotMapper parkingLotMapper;
    private DozerBeanMapper dozerBeanMapper=new DozerBeanMapper();

    public List<ParkingLotDTO> getParkingLots() {
        List<ParkingLot> parkingLotList=parkingLotMapper.getParkingLots();
        List<ParkingLotDTO> parkingLotDTOList=new ArrayList<>();
        for(ParkingLot parkingLot:parkingLotList){
             parkingLotDTOList.add(dozerBeanMapper.map(parkingLot,ParkingLotDTO.class));
        }
        return parkingLotDTOList;
    }

    public void creatParkingLot(ParkingLot parkingLot){
        parkingLotMapper.creatParkingLot(parkingLot);
    }
}

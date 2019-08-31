package tws.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.dto.ParkingBoyDTO;
import tws.dto.ParkingLotDTO;
import tws.entity.ParkingBoy;
import tws.entity.ParkingLot;
import tws.repository.ParkingBoyMapper;
import tws.repository.ParkingLotMapper;

import java.util.*;

@Service
public class ParkingboyService {
    @Autowired
    private ParkingBoyMapper parkingBoyMapper;
    @Autowired
    private ParkingLotMapper parkingLotMapper;
    private DozerBeanMapper dozerBeanMapper=new DozerBeanMapper();

    public List<ParkingBoyDTO> getParkingBoys() {
        List<ParkingBoyDTO> parkingBoyDTOList=new ArrayList<>();
        List<ParkingBoy> parkingBoyList=parkingBoyMapper.getParkingBoys();
        for(ParkingBoy parkingBoy:parkingBoyList){
            ParkingBoyDTO parkingBoyDTO=dozerBeanMapper.map(parkingBoy,ParkingBoyDTO.class);
            parkingBoyDTOList.add(parkingBoyDTO);
        }
        return parkingBoyDTOList;
    }

    public void creatParkingBoy(ParkingBoy parkingBoy) {
        parkingBoy.setId(UUID.randomUUID().toString());
        parkingBoyMapper.creatParkingBoy(parkingBoy);
    }

    public int  addParkinglotToParkingboy(String parkingboyID, String parkinglotID) {
        return parkingLotMapper.addParkinglotToParkingboy(parkingboyID,parkinglotID);

    }

    public List<ParkingLotDTO> getParkingLotsByParkingBoyID(String parkingboyID) {
        List<ParkingLot> parkingLotList=parkingLotMapper.getParkingLotsByParkingBoyID(parkingboyID);
        List<ParkingLotDTO> parkingLotDTOList=new ArrayList<>();
        for(ParkingLot parkingLot:parkingLotList){
            parkingLotDTOList.add(dozerBeanMapper.map(parkingLot,ParkingLotDTO.class));
        }
        return parkingLotDTOList;
    }

    public Map<ParkingBoyDTO, List<ParkingLotDTO>> getParkingBoyAndParkingLots() {
        List<ParkingBoyDTO> parkingBoyDTOList=getParkingBoys();
        Map map=new HashMap();
        for (ParkingBoyDTO parkingBoyDTO:parkingBoyDTOList){
            List<ParkingLotDTO> parkingLotDTOList=getParkingLotsByParkingBoyID(parkingBoyDTO.getId());
            map.put(parkingBoyDTO.getId(),parkingLotDTOList);
        }
        return map;
    }
}

package tws.service;

import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.dto.ParkingBoyDTO;
import tws.entity.ParkingBoy;
import tws.repository.ParkingBoyMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ParkingboyService {
    @Autowired
    private ParkingBoyMapper parkingBoyMapper;
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
}

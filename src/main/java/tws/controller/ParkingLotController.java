package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.dto.ParkingLotDTO;
import tws.entity.ParkingLot;
import tws.service.ParkingLotService;

import java.util.List;

@RestController
@RequestMapping("parkinglots")
public class ParkingLotController {
    @Autowired
    ParkingLotService parkingLotService;
    @GetMapping
    public ResponseEntity getParkingLots(){
        List<ParkingLotDTO> parkingLotDTOList=parkingLotService.getParkingLots();
        return ResponseEntity.ok(parkingLotDTOList);
    }
    @PostMapping
    public ResponseEntity creatParkingLot(@RequestBody ParkingLot parkingLot){
        parkingLotService.creatParkingLot(parkingLot);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}

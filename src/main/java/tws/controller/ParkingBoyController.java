package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.dto.ParkingBoyDTO;
import tws.dto.ParkingLotDTO;
import tws.entity.ParkingBoy;
import tws.service.ParkingboyService;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("parkingboys")
public class ParkingBoyController {
    @Autowired
    ParkingboyService parkingboyService;

    @GetMapping
    public ResponseEntity<List<ParkingBoyDTO>> getParkingBoys(){
        return ResponseEntity.ok(parkingboyService.getParkingBoys());
    }
    @PostMapping
    public ResponseEntity creatParkingBoy(@RequestBody ParkingBoy parkingBoy){
        parkingboyService.creatParkingBoy(parkingBoy);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping({"/{parkingboyID}/parkinglots/{parkinglotID}"})
    public ResponseEntity addParkinglotToParkingboy(@PathVariable String parkingboyID,@PathVariable String parkinglotID){
        int influencerows=parkingboyService.addParkinglotToParkingboy(parkingboyID,parkinglotID);
        if(influencerows!=0){

        return ResponseEntity.ok(influencerows);
        }else {
            return ResponseEntity.noContent().build();
        }
    }
    @GetMapping("/{parkingboyID}/parkinglots")
    public ResponseEntity getParkingLotsByParkingBoyID(@PathVariable String parkingboyID){
        List<ParkingLotDTO> parkingLotDTOList=parkingboyService.getParkingLotsByParkingBoyID(parkingboyID);
        return ResponseEntity.ok(parkingLotDTOList);
    }
    @GetMapping("/parkinglots")
    public ResponseEntity getParkingBoyAndParkingLots(){
        Map<ParkingBoyDTO,List<ParkingLotDTO>> map=parkingboyService.getParkingBoyAndParkingLots();
        return  ResponseEntity.ok(map);
    }

}

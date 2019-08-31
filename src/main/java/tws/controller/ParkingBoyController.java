package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.dto.ParkingBoyDTO;
import tws.entity.ParkingBoy;
import tws.service.ParkingboyService;


import java.util.List;

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


}

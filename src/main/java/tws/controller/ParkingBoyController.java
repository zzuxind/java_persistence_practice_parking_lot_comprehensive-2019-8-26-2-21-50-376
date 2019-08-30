package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tws.dto.ParkingBoyDTO;
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

}

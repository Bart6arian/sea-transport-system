package com.example.seawise.logic.buisness.ship.controller;

import com.example.seawise.logic.buisness.ship.domain.Ship;
import com.example.seawise.logic.buisness.ship.domain.ShipDto;
import com.example.seawise.logic.buisness.ship.exceptions.ShipWithGivenIdDoNotExists;
import com.example.seawise.logic.buisness.ship.mapper.ShipMapper;
import com.example.seawise.logic.buisness.ship.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ship")
@CrossOrigin("*")
public class ShipController {

    private final ShipService service;
    private final ShipMapper mapper;

    @GetMapping(name = "/all")
    public List<ShipDto> showAllShips() {
        return mapper.mapToShipListDto(service.findAllShips());
    }

    @GetMapping("/weightDsc")
    public List<ShipDto> sortByWeightDsc() {
        return mapper.mapToShipListDto(service.sortByWeightRaw());
    }

    @GetMapping("/{id}")
    public ShipDto findShip(@PathVariable("id") Long shipId) throws ShipWithGivenIdDoNotExists {
        return mapper
                .mapToShipDto(service.findByGivenId(shipId)
                        .orElseThrow(ShipWithGivenIdDoNotExists::new));
    }

    @PostMapping(name = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewShip(@RequestBody Ship theShip) {
        service.saveNewShip(theShip);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id) {
        service.deleteById(id);
    }

    @PutMapping("/update")
    public ShipDto updateShip(@RequestBody ShipDto dto) {
        Ship ship = mapper.mapToShip(dto);
        Ship shipToSave = service.saveNewShip(ship);
        return mapper.mapToShipDto(shipToSave);
    }
}

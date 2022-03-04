package com.example.seawise.logic.buisness.ship.controller;

import com.example.seawise.logic.buisness.cargo.domain.Cargo;
import com.example.seawise.logic.buisness.cargo.domain.CargoDto;
import com.example.seawise.logic.buisness.cargo.mapper.CargoMapper;
import com.example.seawise.logic.buisness.ship.domain.*;
import com.example.seawise.logic.buisness.ship.exceptions.ShipWithGivenIdDoNotExists;
import com.example.seawise.logic.buisness.ship.mapper.CargoSectorMapper;
import com.example.seawise.logic.buisness.ship.mapper.ShipMapper;
import com.example.seawise.logic.buisness.ship.service.CargoSectorService;
import com.example.seawise.logic.buisness.ship.service.ShipService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/ship")
@CrossOrigin("*")
public class ShipController {

    private final ShipService service;
    private final CargoSectorService sectorService;
    private final ShipMapper mapper;
    private final CargoSectorMapper sectorMapper;
    private final CargoMapper cargoMapper;

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

    @GetMapping(name = "/{id}/sector")
    public Set<CargoSectorDto> returnShipsSectors(@PathVariable("id") Long shipId) throws ShipWithGivenIdDoNotExists {
        Ship ship = service.findByGivenId(shipId).orElseThrow(ShipWithGivenIdDoNotExists::new);
        Set<CargoSector> sectorOfGivenShip = sectorService.findSectorOfGivenShip(ship);
        return sectorMapper.mapToCargoSectorDtoSet(sectorOfGivenShip);
    }

    @GetMapping(name = "/{id}/sector/{mark}/cargos")
    public List<CargoDto> returnSectorCargos(@PathVariable("id") Long shipId, @PathVariable("mark") SectorMark mark)
            throws ShipWithGivenIdDoNotExists {

        Ship ship = service.findByGivenId(shipId).orElseThrow(ShipWithGivenIdDoNotExists::new);
        Set<CargoSector> shipsSector = sectorService.findSectorOfGivenShip(ship);
        List<Cargo> collectedOfGivenSector = shipsSector.stream()
                .filter(sector -> sector.getMark().equals(mark))
                .flatMap(c -> c.getCargos().stream())
                .collect(Collectors.toList());
        return cargoMapper.mapToCargoDtoList(collectedOfGivenSector);
    }
}

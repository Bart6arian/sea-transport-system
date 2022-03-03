package com.example.seawise.logic.buisness.cargo.controller;

import com.example.seawise.logic.buisness.cargo.domain.Cargo;
import com.example.seawise.logic.buisness.cargo.domain.CargoDto;
import com.example.seawise.logic.buisness.cargo.exceptions.CargoDoNotExistsException;
import com.example.seawise.logic.buisness.cargo.mapper.CargoMapper;
import com.example.seawise.logic.buisness.cargo.service.CargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cargo")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CargoController {

    private final CargoService cargoService;
    private final CargoMapper mapper;

    @GetMapping
    public List<CargoDto> getAll() {
        return mapper.mapToCargoDtoList(cargoService.findAllCargos());
    }

    @GetMapping(name = "/sortByValue")
    public List<CargoDto> findByValueDsc() {
        return mapper.mapToCargoDtoList(cargoService.orderCargoByValue());
    }

    @GetMapping(name = "/{id}")
    public CargoDto findCargoById(@PathVariable("id") Long id) throws CargoDoNotExistsException {
        return mapper
                .mapToDto(cargoService.findCargoByGivenId(id)
                        .orElseThrow(CargoDoNotExistsException::new));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addNewCargo(@RequestBody CargoDto dto) {
        cargoService.addNewCargo(mapper.mapToCargo(dto));
    }

    @PutMapping(name = "/update")
    public CargoDto modifyCargo(@RequestBody CargoDto dto) {
        Cargo cargo = mapper.mapToCargo(dto);
        Cargo cargoToSave = cargoService.addNewCargo(cargo);
        return mapper.mapToDto(cargoToSave);
    }

    @DeleteMapping("/{id}")
    public void deleteCargoOfGivenId(@PathVariable("id") Long id) {
        cargoService.deleteCargoById(id);
    }
}

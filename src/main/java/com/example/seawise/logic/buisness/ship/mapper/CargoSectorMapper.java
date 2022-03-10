package com.example.seawise.logic.buisness.ship.mapper;

import com.example.seawise.logic.buisness.cargo.mapper.CargoMapper;
import com.example.seawise.logic.buisness.ship.domain.CargoSector;
import com.example.seawise.logic.buisness.ship.domain.CargoSectorDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CargoSectorMapper {

    private final CargoMapper mapper;

    public CargoSectorDto mapToCargoSectorDto(CargoSector sector) {
        return new CargoSectorDto(
                sector.getId(),
                sector.getMark(),
                mapper.mapToCargoDtoList(sector.getCargos())
        );
    }

    public CargoSector mapToCargoSector(CargoSectorDto dto) {
        return new CargoSector(
                dto.getId(),
                dto.getMark(),
                mapper.mapToCargoList(dto.getCargoDtoList())
        );
    }

    public Set<CargoSectorDto> mapToCargoSectorDtoSet(Set<CargoSector> sectors) {
        return sectors.stream()
                .map(this::mapToCargoSectorDto)
                .collect(Collectors.toSet());
    }

    public Set<CargoSector> mapToCargoSectorSet(Set<CargoSectorDto> sectors) {
        return sectors.stream()
                .map(this::mapToCargoSector)
                .collect(Collectors.toSet());
    }
}

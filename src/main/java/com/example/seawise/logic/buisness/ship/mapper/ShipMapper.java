package com.example.seawise.logic.buisness.ship.mapper;

import com.example.seawise.logic.buisness.ship.domain.Ship;
import com.example.seawise.logic.buisness.ship.domain.ShipDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ShipMapper {

    public ShipDto mapToShipDto(final Ship ship) {
        return new ShipDto(
                ship.createShipNumber(),
                ship.getShipName(),
                ship.getProductionDate(),
                ship.getRegistrationDate(),
                ship.getType(),
                ship.isWasChipped(),
                ship.getLength(),
                ship.getWidth(),
                ship.getArea(),
                ship.getWeightRaw()
        );
    }

    public Ship mapToShip(final ShipDto dto) {
        return Ship.builder()
                .id((long) dto.getShipNumber().charAt(5))
                .shipName(dto.getShipName())
                .productionDate(dto.getProductionDate())
                .registrationDate(dto.getRegistrationDate())
                .type(dto.getType())
                .wasChipped(dto.isWasChipped())
                .length(dto.getLength())
                .width(dto.getWidth())
                .area(dto.getArea())
                .weightRaw(dto.getWeightRaw())
                .build();
    }

    public List<ShipDto> mapToShipListDto(List<Ship> ships) {
        return ships.stream()
                .map(this::mapToShipDto)
                .collect(Collectors.toList());
    }

}

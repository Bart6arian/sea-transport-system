package com.example.seawise.logic.buisness.ship.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipDto {

    private String shipNumber;
    private String shipName;
    private LocalDate productionDate;
    private LocalDateTime registrationDate;
    private ShipType type;
    private boolean wasChipped;
    private double length;
    private double width;
    private double area;
    private double weightRaw;
    private Set<CargoSectorDto> sectorSetDto;
}

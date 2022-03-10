package com.example.seawise.logic.buisness.ship.domain;

import com.example.seawise.logic.buisness.cargo.domain.CargoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CargoSectorDto {

    private Long id;
    private SectorMark mark;
    private List<CargoDto> cargoDtoList;
}

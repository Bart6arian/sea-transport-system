package com.example.seawise.logic.buisness.cargo.mapper;

import com.example.seawise.logic.buisness.cargo.domain.Cargo;
import com.example.seawise.logic.buisness.cargo.domain.CargoDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CargoMapper {

    public CargoDto mapToDto(Cargo cargo) {
        return new CargoDto(
                cargo.getId(),
                cargo.getName(),
                cargo.getWeight(),
                cargo.getWidth(),
                cargo.getHeight(),
                cargo.getDepth(),
                cargo.isRegistered(),
                cargo.isContracted(),
                cargo.getType(),
                cargo.getDeclaredValue()
        );
    }

    public Cargo mapToCargo(CargoDto dto) {
        return Cargo.builder()
                .id(dto.getId())
                .name(dto.getName())
                .weight(dto.getWeight())
                .width(dto.getWidth())
                .height(dto.getHeight())
                .depth(dto.getDepth())
                .registered(dto.isRegistered())
                .isContracted(dto.isContracted())
                .type(dto.getType())
                .declaredValue(dto.getDeclaredValue())
                .build();
    }

    public List<CargoDto> mapToCargoDtoList(List<Cargo> cargos) {
        return cargos.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public List<Cargo> mapToCargoList(List<CargoDto> cargoDtos) {
        return cargoDtos.stream()
                .map(this::mapToCargo)
                .collect(Collectors.toList());
    }

}

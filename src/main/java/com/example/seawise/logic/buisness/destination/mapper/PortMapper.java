package com.example.seawise.logic.buisness.destination.mapper;

import com.example.seawise.logic.buisness.destination.domain.Port;
import com.example.seawise.logic.buisness.destination.domain.PortDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PortMapper {

    public Port mapToPort(PortDto dto) {
        return new Port(
                dto.getId(),
                dto.getPortName(),
                dto.isAvailable(),
                dto.getCountry(),
                dto.getType()
        );
    }

    public PortDto mapToPortDto(Port port) {
        return new PortDto(
                port.getId(),
                port.createCountryIndex(port.getCountry()),
                port.getPortName(),
                port.isAvailable(),
                port.getCountry(),
                port.getType()
        );
    }

    public List<PortDto> mapToPortDtoList(List<Port> ports) {
        return ports.stream()
                .map(this::mapToPortDto)
                .collect(Collectors.toList());
    }
}

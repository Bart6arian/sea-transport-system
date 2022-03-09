package com.example.seawise.logic.buisness.destination.mapper;

import com.example.seawise.logic.buisness.destination.domain.Destination;
import com.example.seawise.logic.buisness.destination.domain.DestinationDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DestinationMapper {

    private final PortMapper mapper;

    public Destination mapToDestination(DestinationDto dto) {
        return Destination.builder()
                .id(dto.getId())
                .destinationName(dto.getDestinationName())
                .port(mapper.mapToPort(dto.getPortDto()))
                .build();
    }

    public DestinationDto mapToDestinationDto(Destination destination) {
        return new DestinationDto(
                destination.getId(),
                destination.getDestinationName(),
                mapper.mapToPortDto(destination.getPort())
        );
    }

    public List<DestinationDto> mapToDestinationDtoList(List<Destination> destinations) {
        return destinations.stream()
                .map(this::mapToDestinationDto)
                .collect(Collectors.toList());
    }
}

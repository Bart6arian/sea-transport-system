package com.example.seawise.logic.buisness.destination.controller;

import com.example.seawise.logic.buisness.destination.domain.DestinationDto;
import com.example.seawise.logic.buisness.destination.domain.Port;
import com.example.seawise.logic.buisness.destination.domain.PortDto;
import com.example.seawise.logic.buisness.destination.exception.NoSuchDestinationException;
import com.example.seawise.logic.buisness.destination.mapper.DestinationMapper;
import com.example.seawise.logic.buisness.destination.mapper.PortMapper;
import com.example.seawise.logic.buisness.destination.service.DestinationService;
import com.example.seawise.logic.buisness.destination.service.PortService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/destination")
@CrossOrigin("*")
public class DestinationController {

    private final DestinationService destinationService;
    private final DestinationMapper destinationMapper;
    private final PortService portService;
    private final PortMapper portMapper;

    @GetMapping
    public List<DestinationDto> findAllDestinations() {
        return destinationMapper.mapToDestinationDtoList(destinationService.findAll());
    }

    @GetMapping("/{id}")
    public DestinationDto findDestinationByGivenId(@PathVariable ("id") Long id) throws NoSuchDestinationException {
        if(destinationService.checkIfDestinationOfGivenIdExists(id)) {
            return destinationMapper
                    .mapToDestinationDto(destinationService.findDestinationById(id));
        } else throw new NoSuchDestinationException("Destination of id ["+id+"] do not exists");
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveNewDestination(DestinationDto dto) {
        destinationService.saveNewDestination(destinationMapper.mapToDestination(dto));
    }

    @DeleteMapping("/{id}")
    public void deleteDestination(@PathVariable("id") final Long id) {
        destinationService.deleteById(id);
    }

    @GetMapping("/port")
    public List<PortDto> findAllPorts() {
        return portMapper.mapToPortDtoList(portService.findAllPorts());
    }

    @GetMapping("/ports/{id}")
    public PortDto findPortByGivenId(@RequestParam("id") final Long id) {
        return portMapper.mapToPortDto(portService.findById(id));
    }

    @PostMapping(value = "/ports", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void saveNewPort(final PortDto dto) {
        portService.saveNewPort(portMapper.mapToPort(dto));
    }

    @DeleteMapping("/ports")
    public void findIfPortExists(@RequestParam("id") final Long id) {
        portService.deletePortById(id);
    }
}

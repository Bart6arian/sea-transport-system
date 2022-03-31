package com.example.seawise.security.dto;

import com.example.seawise.logic.buisness.destination.domain.DestinationDto;
import com.example.seawise.logic.buisness.ship.domain.ShipDto;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BlockDto {

    private String hash;
    private ShipDto shipDto;
    private DestinationDto destinationDto;

}

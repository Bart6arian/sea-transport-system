package com.example.seawise.logic.buisness.destination.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class DestinationDto {

    private Long id;
    private String destinationName;
    private PortDto portDto;
}

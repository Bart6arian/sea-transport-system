package com.example.seawise.logic.buisness.destination.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class PortDto {

    private Long id;
    private String countryIndex;
    private String portName;
    private boolean isAvailable;
    private String country;
    private PortType type;

}

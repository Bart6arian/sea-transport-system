package com.example.seawise.ship.domain;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipDto {

    private Long id;
    private String shipName;
    private ShipType type;
    private double area;
    private double weightRaw;
}

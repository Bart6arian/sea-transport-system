package com.example.seawise.logic.buisness.ship.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShipDto {

    private String shipNumber;
    private String shipName;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime productionDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime registrationDate;

    private ShipType type;
    private boolean wasChipped;
    private double length;
    private double width;
    private double area;
    private double weightRaw;
}

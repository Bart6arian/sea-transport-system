package com.example.seawise.ship.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity(name = "ships")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shipName;
    private LocalDateTime productionDate;
    private LocalDateTime registrationDate;
    private ShipType type;

    @Column(name = "is_trackable")
    private boolean wasChipped;

    @Column(name = "lenght[m]")
    private double length;

    @Column(name = "width[m]")
    private double width;

    @Column(name = "area[m2]")
    private double area = length * width;

    @Column(name = "weight_without_cargo")
    private double weightRaw;

}

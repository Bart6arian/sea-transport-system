package com.example.seawise.logic.buisness.ship.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "ships")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String shipName;

    private LocalDate productionDate;

    private LocalDateTime registrationDate;

    private ShipType type;

    @Column(name = "is_trackable")
    private boolean wasChipped;

    private double length;
    private double width;

    private double area;

    @Column(name = "weight_without_cargo")
    private double weightRaw;

    @OneToMany(
            mappedBy = "ship",
            cascade = CascadeType.PERSIST,
            fetch = FetchType.LAZY
    )
    private Set<CargoSector> sectors = new HashSet<>();

    public String createShipNumber() {
        return shipName.substring(0,4)
                +"/"+id+"/T"
                +type.ordinal();
    }

}

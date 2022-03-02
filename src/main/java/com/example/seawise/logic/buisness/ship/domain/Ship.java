package com.example.seawise.logic.buisness.ship.domain;

import com.example.seawise.logic.buisness.cargo.domain.Cargo;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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

    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDateTime productionDate;

    @JsonFormat(pattern = "dd-MM-yyyy")
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

    /*@OneToMany
    private List<Cargo> cargoList;*/

    public String createShipNumber() {
        return shipName.substring(0,4)
                +"/"+id+"/T"
                +type.ordinal();
    }

}

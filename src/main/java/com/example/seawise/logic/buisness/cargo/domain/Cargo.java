package com.example.seawise.logic.buisness.cargo.domain;

import com.example.seawise.logic.buisness.ship.domain.CargoSector;
import com.example.seawise.logic.buisness.ship.domain.Ship;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "cargos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private double weight;
    private double width;
    private double height;
    private double depth;

    private boolean registered;

    @Column(name = "military")
    private boolean isContracted;

    @Column(name = "cargo_type")
    private CargoType type;

    @ManyToOne(fetch = FetchType.LAZY)
    private CargoSector sector;

    private double declaredValue;
}

package com.example.seawise.logic.buisness.ship.domain;

import com.example.seawise.logic.buisness.cargo.domain.Cargo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "sectors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CargoSector {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private SectorMark mark;

    @OneToMany(
            cascade = CascadeType.ALL
    )
    private List<Cargo> cargos = new ArrayList<>();

    public void addToCargos(Cargo cargo) {
        cargos.add(cargo);
    }

    public void deleteFromCargos(Cargo cargo) {
        cargos.remove(cargo);
    }
}

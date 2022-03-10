package com.example.seawise.security.blockchain;

import com.example.seawise.logic.buisness.cargo.domain.Cargo;
import com.example.seawise.logic.buisness.cargo.domain.CargoType;
import com.example.seawise.logic.buisness.destination.domain.Destination;
import com.example.seawise.logic.buisness.destination.domain.Port;
import com.example.seawise.logic.buisness.destination.domain.PortType;
import com.example.seawise.logic.buisness.ship.domain.CargoSector;
import com.example.seawise.logic.buisness.ship.domain.SectorMark;
import com.example.seawise.logic.buisness.ship.domain.Ship;
import com.example.seawise.logic.buisness.ship.domain.ShipType;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BlockRunner {

    public static void main(String[] args) {

        List<Cargo> cargoList1 = new ArrayList<>();
        cargoList1.add(new Cargo(1L, "aasds", 243.2, 22.65, 14.3, 4.2, true, true, CargoType.TYPE_II, 2543.2));
        cargoList1.add(new Cargo(2L, "aas22ds", 303.2, 22.65, 17.3, 3.2, false, true, CargoType.ARMORY, 2543.2));
        cargoList1.add(new Cargo(3L, "aasd33s", 293.2, 42.65, 24.3, 4.1, true, true, CargoType.TYPE_I, 2543.2));

        Set<CargoSector> sectors = new HashSet<>();
        sectors.add(new CargoSector(1L, SectorMark.A, cargoList1));

        Block block = new Block("4354",
                new Ship(
                1L,
                "Atlantis",
                LocalDate.of(2010, 10, 12),
                LocalDateTime.now(),
                ShipType.TYPE_I,
                true,
                12.2,
                6.4,
                12.2 * 6.4,
                12000,
                sectors),

                new Destination(
                        1L,
                        "Main",
                        new Port(
                                1L,
                                "Port one",
                                true,
                                "USA",
                                PortType.LAND_INTERIOR)),

                LocalDateTime.now());

        System.out.println(block.getHash());
    }
}

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
import com.example.seawise.security.blockchain.database.DatabaseUnit;
import com.example.seawise.security.exceptions.BlockchainInterruptionException;
import com.example.seawise.security.exceptions.IllegalBlockchainCondition;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;

public class BlockRunner {

    public static void main(String[] args) throws BlockchainInterruptionException, IllegalBlockchainCondition {

        List<Block> chain = new ArrayList<>();

        List<Cargo> cargoList1 = new ArrayList<>();
        cargoList1.add(new Cargo(1L, "aasds", 243.2, 22.65, 14.3, 4.2, true, true, CargoType.TYPE_II, 2543.2));
        cargoList1.add(new Cargo(2L, "aas22ds", 303.2, 22.65, 17.3, 3.2, false, true, CargoType.ARMORY, 2543.2));
        cargoList1.add(new Cargo(3L, "aasd33s", 293.2, 42.65, 24.3, 4.1, true, true, CargoType.TYPE_I, 2543.2));

        Set<CargoSector> sectors = new HashSet<>();
        sectors.add(new CargoSector(1L, SectorMark.A, cargoList1));

        Block block = new Block(null,
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

        Block block1 = new Block(block.getHash(),
                new Ship(
                2L,
                "Atlantis1",
                LocalDate.of(2012, 12, 22),
                LocalDateTime.now(),
                ShipType.GAS,
                true,
                16.2,
                5.6,
                        16.2 * 5.6,
                20000,
                sectors),

                new Destination(
                        2L,
                        "Sydney",
                        new Port(
                                1L,
                                "Port two",
                                false,
                                "Australia",
                                PortType.SEASHORE)),

                LocalDateTime.now());


        chain.add(block);
        chain.add(block1);

        if(Objects.equals(chain.get(1).getPreviousHash(), chain.get(0).getHash())) {
            System.out.println("works fine");
        }

        for (Block b2 : chain) {
            System.out.println("hash: "+b2.getHash());
            System.out.println("previous hash: "+b2.getPreviousHash());
        }

        Chain blockChainExample = new Chain(1L, chain, LocalDateTime.of(2022, 03, 22, 12, 33));
        blockChainExample.removeFromChain(block1);
        System.out.println(blockChainExample.getBlockList().size());
        blockChainExample.addToChain(block1);
        System.out.println(blockChainExample.getBlockList().size());
        DatabaseUnit unit = new DatabaseUnit(1L, blockChainExample,
                LocalDateTime.of(2022, 12, 22, 14, 12));

        System.out.println("DB unit keyHash: "+unit.getUnitHash());

    }
}

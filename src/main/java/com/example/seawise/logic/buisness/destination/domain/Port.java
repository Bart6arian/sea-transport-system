package com.example.seawise.logic.buisness.destination.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "destinations")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Port {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String portName;
    private boolean isAvailable;
    private String country;
    private PortType type;


    public String createCountryIndex(String countryName) {
        return countryName.charAt(0)+""+ countryName.charAt(countryName.length()-1);
    }
}

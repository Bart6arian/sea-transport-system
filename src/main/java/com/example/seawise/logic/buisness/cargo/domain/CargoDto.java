package com.example.seawise.logic.buisness.cargo.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoDto {

    private Long id;
    private String name;
    private double weight;
    private double width;
    private double height;
    private double depth;
    private boolean registered;
    private boolean contracted;
    private CargoType type;
    private double declaredValue;

}

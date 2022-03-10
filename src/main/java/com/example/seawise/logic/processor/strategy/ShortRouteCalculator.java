package com.example.seawise.logic.processor.strategy;

import com.example.seawise.logic.processor.ocean.OceanModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ShortRouteCalculator implements RouteCalculator {

    private OceanModel oceanModel;
    private int predictedDays;

    @Override
    public double optimalRouteVelocity() {
        double routeDistance = oceanModel.shortestRoute().getDistance();
        double distanceInNml = routeDistance * 1.8;
        double v = distanceInNml / (double) predictedDays;
        return v;
    }
}

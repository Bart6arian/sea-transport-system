package com.example.seawise.logic.processor.strategy;

import com.example.seawise.logic.processor.ocean.OceanModel;
import com.example.seawise.logic.processor.ocean.Route;
import com.example.seawise.logic.processor.ocean.RouteSign;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OptimalRouteCalculator implements RouteCalculator {

    private OceanModel model;
    private double days;

    @Override
    public double optimalRouteVelocity() {
        double routeDistance = model.computeMiddleRoute();
        double distanceInNml = routeDistance * 1.8;
        double v = distanceInNml / (double) days;
        return v;
    }

    public void fuelCapacityVerifier(OceanModel oceanModel) {
        if(oceanModel.getArea().compareTo(new BigDecimal("70560000")) > 0) {
            System.out.println("Make full check of fuel status in ship before open road to"
                    + oceanModel.getName());
        }
    }

    public Route checkRouteSafety(Route route) {

        Route routToGo = new Route();
        if(route.getSign() == RouteSign.AF || route.getSign() == RouteSign.ARC) {
            System.out.println("Route with sign " + route.getSign() +
                    " is dangerous because of human/natural conditions");

            routToGo = model.getPossibleRoutes()
                    .stream()
                    .filter(r -> r.getSign() != RouteSign.AF)
                    .filter(r -> r.getSign() != RouteSign.ARC)
                    .filter(r -> r.getDistance() == optimalRouteVelocity())
                    .findFirst()
                    .orElse(null);
        }
        return routToGo;
    }
}

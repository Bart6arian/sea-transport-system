package com.example.seawise.logic.processor.ocean;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OceanModel {

    private String name;
    private BigDecimal area;
    private List<Route> possibleRoutes;

    public Route shortestRoute() {
        return possibleRoutes.stream()
                .min(Comparator.comparing(Route::getDistance))
                .orElseThrow();
    }

    public double computeMiddleRoute() {
        double routeWithMinDistance = shortestRoute().getDistance();
        double routeWithLongestRoute = possibleRoutes.stream()
                .max(Comparator.comparing(Route::getDistance))
                .orElseThrow().getDistance();

        return routeWithLongestRoute - routeWithMinDistance;
    }

}

package com.roadbull.driver.models;

import java.util.List;

/**
 * Created by linhnguyenv1 on 1/24/2017.
 */

public class RBRoute {
    private List<RBLocation> Locations;
    private Route Route;

    public List<RBLocation> getLocations() {
        return Locations;
    }

    public void setLocations(List<RBLocation> locations) {
        Locations = locations;
    }

    public com.roadbull.driver.models.Route getRoute() {
        return Route;
    }

    public void setRoute(com.roadbull.driver.models.Route route) {
        Route = route;
    }
}

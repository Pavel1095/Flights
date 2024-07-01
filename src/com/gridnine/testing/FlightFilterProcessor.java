package com.gridnine.testing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FlightFilterProcessor {
    public List<Flight> filter(List<Flight> flights, List<FlightFilter> filters) {
        List<Flight> filteredFlights = new ArrayList<>(flights);
        for (FlightFilter filter : filters) {
            filteredFlights = filteredFlights.stream().filter(filter::test).collect(Collectors.toList());
        }
        return filteredFlights;
    }
}

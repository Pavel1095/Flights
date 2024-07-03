package com.gridnine.testing;

public class ArrivalBeforeDepartureFilter implements FlightFilter {
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream().anyMatch(s -> s.getArrivalDate().isAfter(s.getDepartureDate()));
    }
}

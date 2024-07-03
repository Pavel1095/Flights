package com.gridnine.testing;

import java.time.LocalDateTime;

public class DepartureBeforeNowFilter implements FlightFilter{
    @Override
    public boolean test(Flight flight) {
        return flight.getSegments().stream().anyMatch(s -> s.getDepartureDate().isAfter(LocalDateTime.now()));
    }
}

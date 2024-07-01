package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;

public class GroundTimeExceedingTwoHoursFilter  implements FlightFilter {
    @Override
    public boolean test(Flight flight) {
        List<Segment> segments = flight.getSegments();
        for (int i = 0; i < segments.size() - 1; i++) {
            LocalDateTime arrival = segments.get(i).getArrivalDate();
            LocalDateTime nextDeparture = segments.get(i + 1).getDepartureDate();
            if (arrival.plusHours(2).isBefore(nextDeparture)) {
                return true;
            }
        }
        return false;
    }
}

package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        List<Flight> flights = FlightBuilder.createFlights();
        FlightFilterProcessor processor = new FlightFilterProcessor();

        List<FlightFilter> filters = List.of(
                new DepartureBeforeNowFilter(),
                new ArrivalBeforeDepartureFilter(),
                new GroundTimeExceedingTwoHoursFilter()
        );

        for (FlightFilter filter : filters) {
            List<Flight> filteredFlights = processor.filter(flights, List.of(filter));
            System.out.println("Filtered flights:");
            filteredFlights.forEach(System.out::println);
        }
    }
}
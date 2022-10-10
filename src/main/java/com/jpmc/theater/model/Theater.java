package com.jpmc.theater.model;

import com.jpmc.theater.Utils;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Theater {

    public static List<Showing> schedule;

    public Theater(LocalDate localDate) {
    }

    static {
        Movie spiderMan = new Movie("Spider-Man: No Way Home", Duration.ofMinutes(90), 12.5, 1);
        Movie turningRed = new Movie("Turning Red", Duration.ofMinutes(85), 11, 0);
        Movie theBatMan = new Movie("The Batman", Duration.ofMinutes(95), 9, 0);
        schedule = List.of(
            new Showing(turningRed, 1, LocalDateTime.of(LocalDate.now(), LocalTime.of(9, 0))),
            new Showing(spiderMan, 2, LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0))),
            new Showing(theBatMan, 3, LocalDateTime.of(LocalDate.now(), LocalTime.of(12, 50))),
            new Showing(turningRed, 4, LocalDateTime.of(LocalDate.now(), LocalTime.of(14, 30))),
            new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.of(16, 10))),
            new Showing(theBatMan, 6, LocalDateTime.of(LocalDate.now(), LocalTime.of(17, 50))),
            new Showing(turningRed, 7, LocalDateTime.of(LocalDate.now(), LocalTime.of(19, 30))),
            new Showing(spiderMan, 8, LocalDateTime.of(LocalDate.now(), LocalTime.of(21, 10))),
            new Showing(theBatMan, 9, LocalDateTime.of(LocalDate.now(), LocalTime.of(23, 0)))
        );
    }

    public Reservation reserve(Customer customer, int sequence, int numberOfTickets) {
        if(sequence <= 0 || sequence > schedule.size()) {
            throw new IllegalArgumentException("sequence " + sequence + " is not a valid argument sequence");
        }
        if(numberOfTickets <= 0) {
            throw new IllegalArgumentException("audience count can not be 0 or negative");
        }
        return new Reservation(customer, schedule.get(sequence - 1), numberOfTickets);
    }

    public static void main(String[] args) {
        Theater theater = new Theater(LocalDate.now());
        Utils.printSchedule(schedule);
    }
}


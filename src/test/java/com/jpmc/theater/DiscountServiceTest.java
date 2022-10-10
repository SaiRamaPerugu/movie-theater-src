package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.DiscountAndFeeService;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DiscountServiceTest {

    DiscountAndFeeService discountAndFeeService;

    @Test
    void specialMovieWithDiscount() {
        Movie spiderMan =  new Movie("spider man", Duration.ofMinutes(90),12.5, 1);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        Reservation reservation = new Reservation(new Customer("sai", "1"), showing,2);
        discountAndFeeService = new DiscountAndFeeService();
        assertEquals(9.375, discountAndFeeService.calculateTicketPrice(showing));
    }

    @Test
    void regularMovieWithoutDiscount() {
        Movie spiderMan =  new Movie("spiderman", Duration.ofMinutes(90),12.5, 0);
        Showing showing = new Showing(spiderMan, 5, LocalDateTime.of(LocalDate.now(), LocalTime.now()));
        Reservation reservation = new Reservation(new Customer("sai", "1"), showing,2);
        discountAndFeeService = new DiscountAndFeeService();
        assertEquals(9.375, discountAndFeeService.calculateTicketPrice(showing));
    }
}

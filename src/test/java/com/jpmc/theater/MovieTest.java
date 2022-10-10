package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.service.DiscountAndFeeService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class MovieTest {
    DiscountAndFeeService discountAndFeeService;

    //Movie with no name should not be created
    @Test
    void movieWithNullMovieName() {
        assertThrows(NullPointerException.class, () -> new Movie(null, Duration.ofMinutes(90),12.5, 1));
    }

    //Movie with no duration
    @Test
    void movieWithZeroDuration() {
        assertThrows(NullPointerException.class, () -> new Movie("Spiderman", null,12.5, 1));
    }

    @Test
    void specialMovieWithDiscount() {
        Movie spiderMan =  new Movie("spiderman", Duration.ofMinutes(90),12.5, 1);
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

package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import com.jpmc.theater.model.Theater;
import com.jpmc.theater.service.DiscountAndFeeService;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class TheaterTest {

    DiscountAndFeeService discountAndFeeService;

    @Test
    void totalFeeForCustomer() {
        Theater theater = new Theater(LocalDate.now());
        Customer john = new Customer("John Doe", "id-12345");
        Reservation reservation = theater.reserve(john, 3, 4);
        discountAndFeeService = new DiscountAndFeeService();
        Showing showing = reservation.getShowing();
        int audienceCount = reservation.getAudienceCount();
        assertEquals(27,discountAndFeeService.calculateTotalFee(showing, audienceCount));
    }

    //Should not allow to reserve a show which is not part of schedule
    @Test
    void sequenceNumberNotPartOfSchedule() {
        Theater theater = new Theater(LocalDate.now());
        Customer john = new Customer("John Doe", "id-12345");
        assertThrows(IllegalArgumentException.class,
                () -> theater.reserve(john, 0, 4));
    }

    //Should not allow reservation with a zero audience.
    @Test
    void audienceCountZeroOrNegative() {
        Theater theater = new Theater(LocalDate.now());
        Customer john = new Customer("John Doe", "id-12345");
        assertThrows(IllegalArgumentException.class,
                () -> theater.reserve(john, 0, 0));
    }

    @Test
    void printMovieSchedule() {
        Theater theater = new Theater(LocalDate.now());
        //theater.printSchedule();
    }
}

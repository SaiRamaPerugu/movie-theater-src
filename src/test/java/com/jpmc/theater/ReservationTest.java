package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Reservation;
import com.jpmc.theater.model.Showing;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationTest {

    //Customer information is neeeded to make a reservation
    @Test
    void reservationWithEmptyCustomerAndShow() {
        assertThrows(NullPointerException.class, () -> new Reservation(null, null,1));
    }

    //Show detail are required for making a reservation
    @Test
    void reservationWithEmptyShow() {
        var customer = new Customer("John Doe", "unused-id");
        assertThrows(NullPointerException.class, () -> new Reservation(customer, null,1));
    }


}

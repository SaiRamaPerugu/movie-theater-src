package com.jpmc.theater;

import com.jpmc.theater.model.Customer;
import com.jpmc.theater.model.Movie;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class CustomerTest {

    //Customer name empty
    @Test
    void customerWithNoName() {
        assertThrows(NullPointerException.class, () -> new Customer(null, "id1"));
    }

    //Customer with no Id
    @Test
    void movieWithZeroDuration() {
        assertThrows(NullPointerException.class, () -> new Customer("customer name", null));
    }
}

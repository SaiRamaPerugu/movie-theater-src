package com.jpmc.theater.service;

import com.jpmc.theater.model.Movie;
import com.jpmc.theater.model.Showing;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import static com.jpmc.theater.Constants.*;


public class DiscountAndFeeService {

    public double calculateTicketPrice(Showing showing) {
        Movie movie = showing.getMovie();
        Double ticketPrice = showing.getMovie().getTicketPrice();
        Double discount = getDiscount(movie.getSpecialCode(), showing.getSequenceOfTheDay(),
                        movie.getTicketPrice(), showing.getStartTime());
        return ticketPrice - discount;
    }

    private double getDiscount(int specialCode, int sequenceOfDay, double ticketPrice, LocalDateTime showTime) {
        double specialDiscount = getSpecialDiscount(specialCode, ticketPrice);
        double sequenceDiscount = getSequenceBasedDiscount(sequenceOfDay);
        double showTimeDiscount = getShowtimeBasedDiscount(showTime, ticketPrice);
        double dateDiscount = getDateBasedDiscount(showTime);
        return Math.max(specialDiscount, Math.max(sequenceDiscount, Math.max(showTimeDiscount, dateDiscount)));
    }

    private double getSequenceBasedDiscount(int showSequence) {
        double sequenceDiscount = 0;
        if (showSequence == DISCOUNT_SEQUENCE_CODE1) {
            sequenceDiscount = DISCOUNT_SEQUENCE_CODE1_VAL; // $3 discount for 1st show
        } else if (showSequence == DISCOUNT_SEQUENCE_CODE2) {
            sequenceDiscount = DISCOUNT_SEQUENCE_CODE2_VAL; // $2 discount for 2nd show
        }
        return sequenceDiscount;
    }

    private double getSpecialDiscount(int movieSpecialCode, double ticketPrice) {
        double specialDiscount = 0;
        if (MOVIE_CODE_SPECIAL == movieSpecialCode) {
            specialDiscount = ticketPrice * 0.2;  // 20% discount for special movie
        }
        return specialDiscount;
    }


    private double getShowtimeBasedDiscount(LocalDateTime showTime, double ticketPrice) {
        double showTimeDiscount = 0;
        LocalDateTime discountStartTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(11, 0));
        LocalDateTime discountEndTime = LocalDateTime.of(LocalDate.now(), LocalTime.of(16,0));
        if(showTime.isAfter(discountStartTime) && showTime.isBefore(discountEndTime)) {
            showTimeDiscount = ticketPrice * 0.25;
        }
        return showTimeDiscount;
    }

    private double getDateBasedDiscount(LocalDateTime showTime) {
        return showTime.getDayOfMonth() == 7 ? 1 : 0;
    }

    public double calculateTotalFee(Showing showing, int audienceCount) {
        return calculateTicketPrice(showing) * audienceCount;
    }

}

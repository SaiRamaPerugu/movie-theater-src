package com.jpmc.theater;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.jpmc.theater.model.Showing;

import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Utils {

    public static String humanReadableFormat(Duration duration) {
        long hour = duration.toHours();
        long remainingMin = duration.toMinutes() - TimeUnit.HOURS.toMinutes(duration.toHours());

        return String.format("(%s hour%s %s minute%s)", hour, handlePlural(hour), remainingMin, handlePlural(remainingMin));
    }

    // (s) postfix should be added to handle plural correctly
    private static String handlePlural(long value) {
        if (value == 1) {
            return "";
        }
        else {
            return "s";
        }
    }

    public static void printSchedule(List<Showing> shows) {
        System.out.println(LocalDate.now());
        System.out.println("===================================================");

        shows.forEach(s -> {
                String jsonString ="";
                try {
                    jsonString = defaultMapper().writeValueAsString(s);
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
                System.out.println(jsonString);
                //System.out.println(s.getSequenceOfTheDay() + ": " + s.getStartTime() + " " + s.getMovie().getTitle() + " " + humanReadableFormat(s.getMovie().getRunningTime()) + " $" + s.getMovieFee())
            }
        );
        System.out.println("===================================================");
    }

    public static ObjectMapper defaultMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper;
    }
}

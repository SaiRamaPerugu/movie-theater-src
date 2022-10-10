package com.jpmc.theater.model;

import com.jpmc.theater.model.Movie;

import java.time.LocalDateTime;

public class Showing {
    private Movie movie;
    private int sequenceOfTheDay;
    private LocalDateTime showStartTime;

    public Showing(Movie movie, int sequenceOfTheDay, LocalDateTime showStartTime) {
        this.movie = movie;
        this.sequenceOfTheDay = sequenceOfTheDay;
        this.showStartTime = showStartTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public LocalDateTime getStartTime() {
        return showStartTime;
    }

    public void setSequenceOfTheDay(int sequenceOfTheDay) {
        this.sequenceOfTheDay = sequenceOfTheDay;
    }


    public int getSequenceOfTheDay() {
        return sequenceOfTheDay;
    }

    @Override
    public String toString() {
        return "Showing{" +
                "movie=" + movie +
                ", sequenceOfTheDay=" + sequenceOfTheDay +
                ", showStartTime=" + showStartTime +
                '}';
    }
}

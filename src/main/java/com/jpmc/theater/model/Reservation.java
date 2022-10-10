package com.jpmc.theater.model;

import java.util.Objects;

public class Reservation {
    private Customer customer;
    private Showing showing;
    private int audienceCount;

    public Reservation(Customer customer, Showing showing, int audienceCount) {
        this.customer = Objects.requireNonNull(customer);
        this.showing = Objects.requireNonNull(showing);
        this.audienceCount = audienceCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Showing getShowing() {
        return showing;
    }

    public int getAudienceCount() {
        return audienceCount;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setShowing(Showing showing) {
        this.showing = showing;
    }

    public void setAudienceCount(int audienceCount) {
        this.audienceCount = audienceCount;
    }
}
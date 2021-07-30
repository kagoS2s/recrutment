package com.source2sea.recruitment;

public class Ticket {
    private final String movieName;
    private final Long id;
    private final double price;

    public Ticket(String movieName, Long id, double price) {
        this.movieName = movieName;
        this.id = id;
        this.price = price;
    }

    public String getMovieName() {
        return movieName;
    }

    public Long getId() {
        return id;
    }

    public double getPrice() {
        return price;
    }
}

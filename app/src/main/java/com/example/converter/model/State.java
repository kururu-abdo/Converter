package com.example.converter.model;

public class State {
    int minutes;
    int degs;
    double seconds;
    public State(  int minutes , int degs, double sec){
        this.seconds = seconds;
        this.degs = degs;
        this.minutes = minutes;
    }

    public double getSeconds() {
        return seconds;
    }

    public int getDegs() {
        return degs;
    }

    public int getMinutes() {
        return minutes;
    }
}

package com.example.converter.model;

public class State {
    int minutes;
    int degs;
    double seconds;
    public State(  int mins, int degs, double sec){
        this.seconds = sec;
        this.degs = degs;
        this.minutes = mins;
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

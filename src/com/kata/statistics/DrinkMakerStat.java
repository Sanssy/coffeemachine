package com.kata.statistics;

public class DrinkMakerStat {

    int served;
    int hotOption;
    double earned;

    public void add(final DrinkMakerStat stat) {
        if (stat != null){
            this.served+=stat.served;
            this.hotOption+=stat.hotOption;
            this.earned+=stat.earned;
        }
    }

    public int timesServed() {
        return served;
    }

    public int hotServed() {
        return hotOption;
    }


}

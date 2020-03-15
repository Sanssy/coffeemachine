package com.kata;

public class DrinkMakerStat {

    public int served;
    public int hotOption;
    public double earned;


    public void add(DrinkMakerStat drinkMakerStat) {
        if (drinkMakerStat != null){
            served+=drinkMakerStat.served;
            hotOption+=drinkMakerStat.hotOption;
            earned+=drinkMakerStat.earned;
        }
    }
}

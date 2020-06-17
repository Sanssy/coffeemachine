package com.kata.statistics;

import com.kata.drinkMaker.Drink;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class Reporting {

    private static final Map<Drink, DrinkMakerStat> statistics = new EnumMap<>(Drink.class);

    public static void addToStatistics(Drink drink, boolean hotOption) {
        if (!statistics.containsKey(drink))
            statistics.put(drink, new DrinkMakerStat());
        if (hotOption && drink.id != Drink.ORANGE_JUICE.id)
            statistics.get(drink).hotOption++;
        statistics.get(drink).served++;
        statistics.get(drink).earned+=drink.price;
    }

    public static DrinkMakerStat stats(final Drink drink){
        return Optional.ofNullable(statistics.get(drink)).orElse(new DrinkMakerStat());
    }

    public static void viewReport() {
        DrinkMakerStat statPerDrink = new DrinkMakerStat();
        Arrays.stream(Drink.values()).forEach(drink-> {
            statPerDrink.add(statistics.get(drink));
            System.out.println(createDrinkStat(drink));
        });
        System.out.println("RESUME |##########| " + displayDrinkStats(statPerDrink));
    }

    private static String createDrinkStat(Drink drink) {
        DrinkMakerStat drinkStat = statistics.containsKey(drink) ? statistics.get(drink) : new DrinkMakerStat();
        return drink.name() + " |##########| " + displayDrinkStats(drinkStat);
    }

    private static String displayDrinkStats(DrinkMakerStat drinkMakerStat){
        return "Served : " + drinkMakerStat.served + " |###| " +
               "Extra hot : " + drinkMakerStat.hotOption + " |###| " +
               "Earned money : " + String.format("%.2f", drinkMakerStat.earned);
    }
}

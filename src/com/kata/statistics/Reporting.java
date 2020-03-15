package com.kata.statistics;

import com.kata.drinkMaker.Drink;

import java.util.EnumMap;
import java.util.Map;
import java.util.Optional;

public class Reporting {

    private static Map<Drink, DrinkMakerStat> statistics = new EnumMap<>(Drink.class);

    public static void addToStatistics(Drink drink, boolean hotOption) {
        if (!statistics.containsKey(drink))
            statistics.put(drink, new DrinkMakerStat());
        if (hotOption)
            statistics.get(drink).hotOption++;
        statistics.get(drink).served++;
        statistics.get(drink).earned+=drink.price;
    }

    public static DrinkMakerStat stats(final Drink drink){
        return Optional.ofNullable(statistics.get(drink)).orElse(new DrinkMakerStat());
    }

    public static void viewReport() {
        DrinkMakerStat statPerDrink = new DrinkMakerStat();
        for (final Drink drink : Drink.values()) {
            statPerDrink.add(statistics.get(drink));
            System.out.println(createDrinkStat(drink));
        }
        System.out.println("RESUME |##########| " + displayDrinkStats(statPerDrink));
    }

    private static String createDrinkStat(Drink drink) {
        StringBuilder drinkStat = new StringBuilder();
        DrinkMakerStat stat;

        if (statistics.containsKey(drink))
            stat = statistics.get(drink);
        else
            stat = new DrinkMakerStat();

        return drinkStat.append(drink.name()).append(" |##########| ").append(displayDrinkStats(stat)).toString();
    }

    private static String displayDrinkStats(DrinkMakerStat drinkMakerStat){
        StringBuilder drinkLine = new StringBuilder();
        drinkLine.append("Served : ").append(drinkMakerStat.served).append(" |###|")
                .append(" Extra hot : ").append(drinkMakerStat.hotOption).append(" |###|")
                .append(" Earned money : ").append(String.format("%.2f",drinkMakerStat.earned));
        return drinkLine.toString();
    }
}

package com.kata;

import java.util.EnumMap;
import java.util.Map;

public class Reporting {

    private static Map<Drink,DrinkMakerStat> statistics = new EnumMap<>(Drink.class);

    public static void addToStats(Drink drink, boolean hotOption) {
        if (!statistics.containsKey(drink.id))
            statistics.put(drink, new DrinkMakerStat());
        if (hotOption)
            statistics.get(drink).hotOption++;
        statistics.get(drink).served++;
        statistics.get(drink).earned+=drink.price;
    }

    public static void showReport() {
        DrinkMakerStat statPerDrink = new DrinkMakerStat();
        for (final Drink drink : Drink.values()) {
            statPerDrink.add(statistics.get(drink));
            System.out.println(buildDrinkStat(drink));
        }
        System.out.println("RESUME |##########| " + displayDrinkStats(statPerDrink));
    }

    private static String buildDrinkStat(Drink drink) {
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
        drinkLine.append("Served : ").append(drinkMakerStat.served)
                .append(" |###|").append(" Extra hot : ")
                .append(drinkMakerStat.hotOption)
                .append(" |###|").append(" Earned money : ")
                .append(String.format("%.2f",drinkMakerStat.earned));

                return drinkLine.toString();
    }
}

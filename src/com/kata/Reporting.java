package com.kata;

import java.util.EnumMap;
import java.util.Map;

public class Reporting {

    private static Map<Drink,DrinkMakerStat> statistics = new EnumMap<>(Drink.class);

    public static void add(Drink drink, boolean hotOption) {
        if (!statistics.containsKey(drink.id)){
            statistics.put(drink, new DrinkMakerStat());
        }
        statistics.get(drink).served++;
        if (hotOption)
            statistics.get(drink).hotOption++;
        statistics.get(drink).earned+=drink.price;
    }

    public static String publishStats(DrinkMakerStat drinkMakerStat){
        StringBuilder stats = new StringBuilder();
        stats.append("served : ").append(drinkMakerStat.served)
                .append(';').append(" with hot option : ")
                .append(drinkMakerStat.hotOption)
                .append(';').append(" money earned : ")
                .append(String.format("%.2f",drinkMakerStat.earned));

                return stats.toString();
    }

    private static String buildDrinkStat(Drink drink) {
        DrinkMakerStat stat;
        if (statistics.containsKey(drink)){
            stat = statistics.get(drink);
        } else {
            stat = new DrinkMakerStat();
        }

        StringBuilder sb = new StringBuilder();
        sb.append(drink.name())
                .append(" : ")
                .append(publishStats(stat));
        return sb.toString();
    }

    public static void showReport() {
        final DrinkMakerStat total = new DrinkMakerStat();
        for (final Drink drink : Drink.values()) {
            total.add(statistics.get(drink));
            System.out.println(buildDrinkStat(drink));
        }
        System.out.println(new StringBuilder("TOTAL:")
                .append(publishStats(total))
                .toString());
    }
}
